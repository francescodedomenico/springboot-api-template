package com.template.springnativerest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.template.springnativerest.services.SpringNativeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SpringNativeController {

    @Autowired
    SpringNativeService springNativeService;

    @Operation(summary = "Hello world endpoint")
    @GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody ResponseEntity<String> helloWorld() {
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body("Hello!");
    }

    @Operation(summary = "Test exception endpoint")
    @GetMapping(path = "/testexception", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> testException() {
        springNativeService.testException();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
