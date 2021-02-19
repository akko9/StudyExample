package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    private final Map<Integer,User> map=new HashMap<>();

    public UserServiceImpl() {
        this.map.put(1,new User("1","akko",10));
        this.map.put(2,new User("2","fizz",20));
        this.map.put(3,new User("3","mf",30));
        this.map.put(4,new User("4","ovo",40));
    }

    @Override
    public Mono<User> getUserById(String id) {
        return Mono.justOrEmpty(this.map.get(Integer.valueOf(id)));
    }

    @Override
    public Flux<User> findAll() {
        return Flux.fromIterable(this.map.values());
    }

    @Override
    public Mono<Void> addUser(Mono<User> user) {
        return user.doOnNext(person->{
            map.put(map.size()+1,person);
        }).thenEmpty(Mono.empty());
    }
}
