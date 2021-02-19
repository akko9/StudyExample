package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        Book bookInfo = run.getBean(Book.class);
        System.out.println(bookInfo);
        User user = run.getBean(User.class);
        System.out.println(user);
        System.out.println("+++++++++++++++++++++++++++++++++++");
        boolean book = run.containsBean("book");
        System.out.println(book);
        boolean userInfo1 = run.containsBean("userInfo");
        System.out.println(userInfo1);


    }

}
