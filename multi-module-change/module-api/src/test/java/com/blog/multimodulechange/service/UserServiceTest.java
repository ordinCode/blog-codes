package com.blog.multimodulechange.service;

import com.blog.multimodulechange.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void save() {
        User user = User.builder()
                .name("홍길동")
                .password("1234")
                .build();

        Long id = userService.save(user);
        assertThat(id).isNotNull();
    }
}
