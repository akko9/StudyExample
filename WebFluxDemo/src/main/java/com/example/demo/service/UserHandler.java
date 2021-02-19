package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {
    private final UserService userService;
    public UserHandler(UserService userService){
        this.userService=userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notFound=ServerResponse.notFound().build();
        Mono<User> user = this.userService.getUserById(String.valueOf(id));

       return user.flatMap(person-> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person))).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        Flux<User> users = this.userService.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
    }
}
