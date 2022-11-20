package com.batch80.pointofsalebatch80.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/test")
@CrossOrigin
public class ControllerTest {

    @GetMapping("get-text-1")
    public void getMyTet(){
        System.out.println("my first app");
    }

    @GetMapping("get-text-2")
    public void getMyTet2(){
        System.out.println("Spring Boot");
    }
}
