package com.aula.entrega.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<String> inicial() {
        return ResponseEntity.status(HttpStatus.OK).body("URI inicial");
    }
}
