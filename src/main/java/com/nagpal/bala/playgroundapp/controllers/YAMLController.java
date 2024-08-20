package com.nagpal.bala.playgroundapp.controllers;

import com.nagpal.bala.playgroundapp.yaml.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class YAMLController {

    @PostMapping("/convert-to-yaml")
    public ResponseEntity<String> convertYAML(@RequestBody Order order) {
        log.info("Converting to YAML: {}", order);
        return ResponseEntity.ok("YAML Controller");
    }

}
