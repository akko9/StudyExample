package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable("id")String id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public Flux<User> getUsers(){
        return userService.findAll();
    }
    @PostMapping("/user")
    public Mono<Void> getUsers(@RequestBody User user){
        Mono<User> userMono=Mono.just(user);
        return userService.addUser(userMono);
    }
}
