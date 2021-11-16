package com.nagpal.bala.playgroundapp.logging;

import com.google.common.collect.ImmutableSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.*;
import org.zalando.logbook.autoconfigure.LogbookProperties;
import org.zalando.logbook.json.JsonBodyFilters;
import org.zalando.logbook.json.JsonHttpLogFormatter;
import org.zalando.logbook.json.JsonPathBodyFilters;

import java.io.IOException;

@Configuration
public class LogbookConfiguration {

    @Bean
    public Logbook logbook() {
        //https://github.com/zalando/logbook

        Logbook logbook = Logbook.builder()
                .condition(Conditions.exclude(
                        Conditions.requestTo("/health"),
                        Conditions.contentType("application/octet-stream"),
                        Conditions.header("X-Secret", "dummy")))
//                .bodyFilter(JsonPathBodyFilters.jsonPath("$.type").replace("X"))
                .bodyFilter(JsonBodyFilters.replaceJsonStringProperty(ImmutableSet.of("type"), "X"))
                .bodyFilter(JsonPathBodyFilters.jsonPath("$.color").delete())
//                .responseFilter(ResponseFilters.replaceBody(message -> Conditions.contentType("place-content-type-to-test").test(message)
//                        ? "It just keeps going and going..." : null))
                .responseFilter(ResponseFilters.replaceBody(message -> {
                            try {
                                return message.getBodyAsString().contains("suv") ? message.getBodyAsString().replace("suv", "xxx") : "";
                            } catch (IOException e) {
                                throw new RuntimeException();
                            }
                        }))
                .strategy(new WithoutBodyStrategy())
                .headerFilter(headers -> {
                    return headers.delete("postman-token");
                })
                .sink(new DefaultSink(new SplunkHttpLogFormatter(), new DefaultHttpLogWriter()))

                .build();

       //does not work. works via configuration only. LogbookProperties is internal API
        new LogbookProperties().getObfuscate().getHeaders().add("user-agent");

        return logbook;
    }
}
