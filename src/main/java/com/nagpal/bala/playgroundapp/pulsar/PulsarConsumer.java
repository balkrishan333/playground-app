package com.nagpal.bala.playgroundapp.pulsar;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.TextMapGetter;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PulsarConsumer {

    @Autowired
    private PulsarAppClient appClient;

    public Consumer<byte[]> getConsumer(String topic) {

        Consumer<byte[]> consumer;
        PulsarClient pulsarClient = appClient.getPulsarClient();

        try {
            consumer = pulsarClient.newConsumer()
                    .topic(topic)
                    .subscriptionName("my-subscription")
                    .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
                    .intercept(new OTelPulsarConsumerInterceptor())
                    .messageListener(messageListener)
                    .subscribe();

        } catch (PulsarClientException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return consumer;
    }

    MessageListener<byte[]> messageListener = (consumer, msg) -> {

        OpenTelemetry globalOpenTelemetry = GlobalOpenTelemetry.get();
        Tracer tracer = globalOpenTelemetry.getTracer("");

        Context extractedContext = extractContextFromMessage(msg);

        Span span = tracer.spanBuilder("listener span").setParent(extractedContext).startSpan();
        span.setAttribute("ImplClass", "PulsarConsumer");
        span.setAttribute("message", new String(msg.getData()));

        try(Scope scope = span.makeCurrent()) {
            try {
                System.out.println("msg.traceparent = " + msg.getProperty("traceparent"));
                System.out.println("Message received : " + new String(msg.getData()));
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        } finally {
            span.end();
        }
    };

    private Context extractContextFromMessage(Message message) {

        TextMapGetter<Message<?>> getter =
                new TextMapGetter<>(){

                    @Override
                    public String get(Message<?> message, String key) {
                        return message.getProperties().get(key);
                    }

                    @Override
                    public Iterable<String> keys(Message<?> message) {
                        return message.getProperties().keySet();
                    }

                };

        return GlobalOpenTelemetry.getPropagators().getTextMapPropagator()
                .extract(Context.current(), message, getter);

    }
}
