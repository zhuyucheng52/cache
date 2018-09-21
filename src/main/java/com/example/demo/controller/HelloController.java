package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.User;
import com.example.demo.service.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(value = "/cache/user/{id:\\d+}")
    public User getUserByName(@PathVariable("id") Long id) {
        log.info("Get user by id: {}", id);
        return service.getUserById(id);
    }

    @DeleteMapping(value = "/cache/user/{id:\\d+}")
    public void deleteUserByName(@PathVariable("id") Long id) {
        log.info("Delete user by id: {}", id);
        service.deleteUserById(id);
    }

    @DeleteMapping(value = "/cache/user")
    public void deleteUsers() {
        log.info("Delete users");
        service.deleteUsers();
    }

    @GetMapping(value = "/cache/address")
    public List<Address> getAddresses() {
        log.info("Get addresses");
        return service.getAddress();
    }

    @DeleteMapping(value = "/cache/address")
    public void deleteAddress() {
        log.info("Delete address");
        service.deleteAddress();
    }
}
