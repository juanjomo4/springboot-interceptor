package com.juanjo.curso.springboot.app.interceptor.springboot_interceptor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("f/oo")
    public Map<String, String> foo() {
        return Collections.singletonMap("message", "Hello World! Handler foo del controlador FooController");
    }

    @GetMapping("/bar")
    public Map<String, String> bar() {
        return Collections.singletonMap("message", "Hello World! Handler bar del controlador FooController");
    }

    @GetMapping("/baz")
    public Map<String, String> baz() {
        return Collections.singletonMap("message", "Hello World! Handler baz del controlador FooController");
    }

}
