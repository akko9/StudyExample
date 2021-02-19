package com.example.demo.config;

import com.example.demo.entity.Book;
import com.example.demo.entity.Car;
import com.example.demo.entity.User;
import com.example.demo.filter.CustomHideMethodFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = true)
@EnableConfigurationProperties(Car.class)
public class MyConfig {


    /*
    user依赖book
     */
     //判断如果book注册,user才注册

    @Bean("book")
    public Book getBook(){
        return new Book();
    }

    @ConditionalOnBean(name = "book")
    @Bean("userInfo")
    public User getUser(){
        return new User();
    }

    @Bean
    public HiddenHttpMethodFilter HiddenHttpMethodFilter(){
        CustomHideMethodFilter customHideMethodFilter = new CustomHideMethodFilter();
        customHideMethodFilter.setMethodParam("_h");
        return customHideMethodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcAutoConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
}
