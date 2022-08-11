/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.template.springnativerest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringNativeController {

@GetMapping(path="/hello", produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> helloWorld(){
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body("Hello!");
}
}
