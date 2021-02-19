package com.example.demo.Server;

import com.example.demo.service.UserHandler;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import com.sun.corba.se.spi.activation.Server;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class RouterServer  {
    //1.创建router
    private RouterFunction<ServerResponse> routerFunction(){
        UserService userService=new UserServiceImpl();
        UserHandler handler=new UserHandler(userService);
        //2.创建路由
        return RouterFunctions.route(
                GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)),handler::getUserById
        ).andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)),handler::findAll);

    }
    //3.创建服务器完成适配
    public void createServer(){
        //路由与handler适配
        RouterFunction<ServerResponse> route=routerFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }

    public static void main(String[] args) throws IOException {
        RouterServer routerServer=new RouterServer();
        routerServer.createServer();
        System.out.println("enter to exit");
        System.in.read();

    }
}
