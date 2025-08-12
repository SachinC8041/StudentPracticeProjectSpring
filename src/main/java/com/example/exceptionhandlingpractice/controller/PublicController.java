package com.example.exceptionhandlingpractice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/info")
    public String info() {
        return "This is a public endpoint. No auth required.";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
