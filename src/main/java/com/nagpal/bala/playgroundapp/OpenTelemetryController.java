package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.pulsar.PulsarConsumer;
import com.nagpal.bala.playgroundapp.pulsar.PulsarProducer;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.extension.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public final class OpenTelemetryController {

    @Autowired
    private PulsarProducer pulsarProducer;
    @Autowired
    private PulsarConsumer pulsarConsumer;

    @RequestMapping(method = RequestMethod.GET, path = "/tracing")
    public String tracing() {

        { // This is using Open telemetry SDK. Should be used only if you are exposing the code as lib
            //OpenTelemetry openTelemetry = OpenTelemetryFactory.getInstance();
            //We recommend calling getTracer once per component during initialization and retaining a handle to the tracer,
            // rather than calling getTracer repeatedly
            //Tracer tracer = openTelemetry.getTracer("");
        }


        //Global open telemetry, as suggested by community. It works only if SDK initialization code in OpenTelemetryFactory
        // is removed
        OpenTelemetry globalOpenTelemetry = GlobalOpenTelemetry.get();
        Tracer tracer = globalOpenTelemetry.getTracer("");

        log.info("tracer {} ", tracer);

        //get current span before creating new one. This is just to get current trace id. not used anywhere
        Span parentSpan = Span.current();
        log.info("parentSpan {} ",  parentSpan);
        log.info("parent span trace id {} ", parentSpan.getSpanContext().getTraceId());

        String response = null;

        //create new span
        Span span = tracer.spanBuilder("customSpan")
                            .setSpanKind(SpanKind.SERVER)
                            .startSpan();

        //create tags in span
        span.setAttribute("messageType", "v2");
        span.setAttribute("tenant", "dummy tenant");

        //add event (logs) in span
        span.addEvent("event_name", Attributes.of(
                AttributeKey.stringKey("item_key1"), "item_key1",
                AttributeKey.stringKey("item_key2"), "item_key2",
                AttributeKey.stringKey("item_key3"), "item_key3"
        ));

        log.info("span {}", span);
        log.info("span trace id {}", span.getSpanContext().getTraceId());

        // put the span into the current Context
        try (Scope scope = span.makeCurrent()) {
            // your use case
            response = tracing1(tracer);
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }

        {// Changing the existing span does not work (PropagationSpan) . Need to create a new span for adding information.
            /*Span span2 = Span.current();
            span2.setAttribute("messageType", "v2");
            span2.setAttribute("tenant", "dummy tenant");
            System.out.println("span = " + span2);
            String response = tracing1();*/
        }

        return response;
    }

    /*
        Without @WithSpan annotation, this method won't be there in trace. To trace local method calls, we need to
        use @WithSpan annotation.
     */
    @WithSpan
    private String tracing1(Tracer tracer) {

        Span span = tracer.spanBuilder("customSpan_2")
                .setSpanKind(SpanKind.SERVER).startSpan();

        span.setAttribute("method", "tracing1");

        System.out.println("span = " + span);

        // put the span into the current Context
        try (Scope scope = span.makeCurrent()) {
            // your use case
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }
        return "tracing 1 : " + tracing2();
    }

    @WithSpan
    private String tracing2() {
        return "tracing 2";
    }

    @GetMapping(path = "/tracing/pulsar/publish/{topic}")
    public ResponseEntity<String> tracePulsarPublish(@PathVariable String topic, @RequestParam String message) {
        log.info("Sending message to pulsar topic : " + topic);
        log.info("Message: " + message);

        MessageId messageId;
        try {
            messageId = pulsarProducer.getProducer(topic).send(message.getBytes());
            log.info("Message published with id: {}", messageId);
        } catch (PulsarClientException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.ok("Message published. Message id: " + messageId);
    }

    @GetMapping(path = "/tracing/pulsar/consume/{topic}")
    public ResponseEntity<String> tracePulsarConsume(@PathVariable String topic) {

        log.info("Retrieving message from topic: " + topic);

        Consumer<byte[]> consumer = pulsarConsumer.getConsumer(topic);
        Message<byte[]> message = null;

        OpenTelemetry globalOpenTelemetry = GlobalOpenTelemetry.get();
        Tracer tracer = globalOpenTelemetry.getTracer("");

        Span span = tracer.spanBuilder("pulsar custom span")
                .setSpanKind(SpanKind.SERVER)
                .startSpan();

        //create tags in span
        span.setAttribute("messageType", "v2");
        span.setAttribute("tenant", "dummy tenant");

        try (Scope scope = span.makeCurrent()) {
            try {
                message = consumer.receive();
            } catch (PulsarClientException e) {
                log.error(e.getMessage());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
            }

            log.info("Message received from pulsar");

            try {
                consumer.acknowledge(message.getMessageId());
                consumer.close();
            } catch (PulsarClientException e) {
                log.error(e.getMessage());
            }
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }

        return ResponseEntity.ok(new String(message.getData()));
    }
}
