package com.nagpal.bala.playgroundapp.hateoas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("v1")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestHeader("Accept") String contentType) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name,contentType)).withSelfRel());
//        greeting.add(linkTo(methodOn(GreetingController.class).greetingDetail(name, "123", name)).withRel("details"));
        //https://restfulapi.net/hateoas/
        greeting.add(linkTo(methodOn(GreetingController2.class).greetingDetail2(name, "123")).withRel("details").withType(contentType));

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @RequestMapping("/greeting/details")
    public HttpEntity<Greeting> greetingDetail(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "id") String id,
            @RequestParam(value = "version") String version) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
