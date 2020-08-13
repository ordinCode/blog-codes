package com.blog.multimodulechange.controller;

import com.blog.multimodulechange.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public User getTest(){
        return User.builder()
                .name("홍길동")
                .password("1234")
                .build();
    }
}
