package com.waitaty.english.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }


    @GetMapping(path = "test")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello from not secured endpoint");
    }

}
