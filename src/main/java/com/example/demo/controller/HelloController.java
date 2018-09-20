package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auth: yucheng
 * Date: 2018/9/6
 * Desc:
 */
@RestController
@CacheConfig(cacheNames = "userCache")
@Slf4j
public class HelloController {
    @Autowired
    private HelloServiceImpl service;

    @GetMapping(value = "/cache/{id:\\d+}")
    public User getUserByName(@PathVariable("id") Long id) {
        log.info("Get user by id: {}", id);
        return service.getUserById(id);
    }

    @DeleteMapping(value = "/cache/{id:\\d+}")
    public void deleteUserByName(@PathVariable("id") Long id) {
        log.info("Delete user by id: {}", id);
        service.deleteUserById(id);
    }
}
