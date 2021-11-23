package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.opentelemetry.OpenTelemetryFactory;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.*;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);


    @Autowired
    private AppConfiguration appConfiguration;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        Map<String, String> secrets = appConfiguration.getClientSecrets();
        System.out.println("secrets = " + secrets);
        return "Hello from server !!!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tracing")
    public String tracing() {
        OpenTelemetry openTelemetry = OpenTelemetryFactory.getInstance();
        //We recommend calling getTracer once per component during initialization and retaining a handle to the tracer,
        // rather than calling getTracer repeatedly
        Tracer tracer = openTelemetry.getTracer("");

        //Global open telemetry, as suggested by community, does not work
//        OpenTelemetry globalOpenTelemetry = GlobalOpenTelemetry.get();
//        Tracer tracer = globalOpenTelemetry.getTracer("");

        System.out.println("tracer = " + tracer);

        //get current span before creating new one. This is just to get current trace id. not used anywhere
        Span parentSpan = Span.current();
        System.out.println("parentSpan = " + parentSpan);
        System.out.println("parent span trace id = " + parentSpan.getSpanContext().getTraceId());

        String response = null;

        //create new span
        Span span = tracer.spanBuilder("customSpan")
                    .setSpanKind(SpanKind.SERVER).startSpan();

        //create tags in span
        span.setAttribute("messageType", "v2");
        span.setAttribute("tenant", "dummy tenant");

        //add event (logs) in span
        span.addEvent("event_name", Attributes.of(
                AttributeKey.stringKey("item_key1"), "item_key1",
                AttributeKey.stringKey("item_key2"), "item_key2",
                AttributeKey.stringKey("item_key3"), "item_key3"
        ));

        System.out.println("span = " + span);
        System.out.println("span trace id = " + span.getSpanContext().getTraceId());

        // put the span into the current Context
        try (Scope scope = span.makeCurrent()) {
            // your use case
             response = tracing1(tracer);
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }

        // Changing the existing span does not work (PropagationSpan) . Need to create a new span for adding information.
        /*Span span2 = Span.current();
        span2.setAttribute("messageType", "v2");
        span2.setAttribute("tenant", "dummy tenant");
        System.out.println("span = " + span2);
        String response = tracing1();*/
        return response;
    }

    private String tracing1(Tracer tracer) {

        Span span = tracer.spanBuilder("customSpan_2")
                .setSpanKind(SpanKind.SERVER).startSpan();

        span.setAttribute("method", "tracing1");

        System.out.println("span = " + span);
        System.out.println("span trace id = " + span.getSpanContext().getTraceId());
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

    private String tracing2() {
        return "tracing 2";
    }
}