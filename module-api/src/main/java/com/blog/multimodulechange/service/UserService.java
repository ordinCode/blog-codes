package com.blog.multimodulechange.service;

import com.blog.multimodulechange.domain.User;
import com.blog.multimodulechange.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long save(User user) {
        return userRepository.save(user).getId();
    }
}
