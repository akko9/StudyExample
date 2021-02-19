package com.example.demo.client;

import com.example.demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class UserClient {
    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient=WebClient.create("http://127.0.0.1:55353");

        //查询
        String id="1";
        User user = webClient.get().uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        System.out.println(user.toString());
    }
}
