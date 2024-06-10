package com.nagpal.bala.playgroundapp.controllers;


import com.nagpal.bala.playgroundapp.k8s.CreatePod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class K8sController {

    @PostMapping("/create-pod")
    public ResponseEntity<String> createPod(@RequestBody Map<String, String> body) {

        if (body == null) {
            return ResponseEntity.badRequest().body("Request body is empty");
        }

        if (!body.containsKey("apiServer") || !body.containsKey("jsonPayload") || !body.containsKey("token")) {
            return ResponseEntity.badRequest().body("Request body is missing required fields");
        }

        String apiServer = body.get("apiServer");
        String jsonPayload = body.get("jsonPayload");
        String token = body.get("token");
        String namespace = body.getOrDefault("namespace", "default");

        CreatePod pod = new CreatePod(apiServer, jsonPayload, namespace, token);
        try {
            pod.create();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error creating pod: " + e.getMessage());
        }
        return ResponseEntity.ok("Pod created");
    }
}
