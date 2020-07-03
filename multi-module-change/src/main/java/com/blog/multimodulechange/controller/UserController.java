package com.blog.multimodulechange.controller;

import com.blog.multimodulechange.domain.User;
import com.blog.multimodulechange.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public User getTest(){
        return User.builder()
                .name("홍길동")
                .password("1234")
                .build();
    }
}
