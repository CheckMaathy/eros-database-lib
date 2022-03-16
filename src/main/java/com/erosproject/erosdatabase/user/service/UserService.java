package com.erosproject.erosdatabase.user.service;

import com.erosproject.erosdatabase.repository.UserRepository;
import com.erosproject.erosdatabase.user.dto.UserDTO;
import com.erosproject.erosdatabase.user.model.User;
import com.erosproject.erosdatabase.user.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(cacheNames = "userCache", key = "{#root.methodName, #userCode}", cacheManager = "redisCacheManager")
    public UserDTO findUserByUsername(String username) {
        return userMapper.toDTO(userRepository.findByUsername(username));
    }

}
