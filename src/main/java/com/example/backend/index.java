package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @GetMapping("/")
    public String initial(){
        return "Api is working";
    }

    @PostMapping("/")
    public Test addData(@RequestBody Test userData){
        return userData;
    }
}

class Test{
    public String name;
    public String email;
    public int age;
}