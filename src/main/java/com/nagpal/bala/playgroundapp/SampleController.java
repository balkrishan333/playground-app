package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.opentelemetry.OpenTelemetryFactory;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
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
        Tracer tracer =
                openTelemetry.getTracer("");

        String response = null;
        Span span = tracer.spanBuilder("balkrishan span").startSpan();
        span.setAttribute("messageType", "v2");
        span.setAttribute("tenant", "dummy tenant");
        System.out.println("span = " + span);
        // put the span into the current Context
        try (Scope scope = span.makeCurrent()) {
            // your use case
             response = tracing1();
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }
        return response;
    }

    private String tracing1() {
        return "tracing 1 : " + tracing2();
    }

    private String tracing2() {
        return "tracing 2";
    }
}