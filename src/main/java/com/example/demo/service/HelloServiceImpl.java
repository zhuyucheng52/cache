package com.example.demo.service;

import com.example.demo.caches.UserCache;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Auth: yucheng
 * Date: 2018/9/6
 * Desc:
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UserCache userCache;

    @Resource(name = "idUserCache")
    private Cache cache;

    @Override
    public User getUserById(Long id) {
        return userCache.getUserById(id);
    }

    @Override
    public int deleteUserById(Long id) {
        return userCache.deleteUserById(id);
    }


}
