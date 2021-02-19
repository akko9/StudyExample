package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @Autowired
    Car car;

    @RequestMapping(value = "/car",method = RequestMethod.GET)
    public String getCar(){
        System.out.println(car.getName());
        return "index";
    }
    @ResponseBody
    @RequestMapping(value = "/deleteCar",method = RequestMethod.DELETE)
    public String deleteCar(){
        return "删除";
    }
}
