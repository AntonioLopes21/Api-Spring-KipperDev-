package com.devInDev.first_spring_app.controller;

import com.devInDev.first_spring_app.domain.User;
import com.devInDev.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//STATELLES -> TOKEN. a cada nova requisição eu recebo todas as informações que preciso para fazer aquela funcionalidade requisitada (API REST),
// STATEFULL -> o status de cada cliente é mantido no servidor
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    //injeção de dependência
    @Autowired
    private HelloWorldService helloWorldService;

    // public HelloWorldController(HelloWorldService helloWorldService) {
    //    this.helloWorldService = helloWorldService;
    //}

    //CRIAR ENDPOINT
    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Antônio");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = " sem filtro") String filter, @RequestBody User body) {
        return "Hello world POST " + body.getName() + id + filter;
    }
}
