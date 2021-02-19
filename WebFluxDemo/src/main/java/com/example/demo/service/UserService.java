package com.example.demo.service;

import com.example.demo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Mono<User> getUserById(String id);

    Flux<User> findAll();

    Mono<Void> addUser(Mono<User> user);
}
