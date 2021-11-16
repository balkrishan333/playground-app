package com.nagpal.bala.playgroundapp.hateoas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("v2")
public class GreetingController2 {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping(path = "greeting2", produces = "text/html")
    public HttpEntity<Greeting> greeting2(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController2.class).greeting2(name)).withSelfRel());
        greeting.add(linkTo(methodOn(GreetingController2.class).greetingDetail2(name, "123")).withRel("details"));

        MultiValueMap<String, String> headers = new HttpHeaders();
        List<String> versions = new ArrayList<>();
        versions.add("v3");

        headers.put("api-version", versions);

        return new ResponseEntity<>(greeting, headers, HttpStatus.OK);
    }

    @RequestMapping("/greeting2/details")
    public HttpEntity<Greeting> greetingDetail2(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "id") String id) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
