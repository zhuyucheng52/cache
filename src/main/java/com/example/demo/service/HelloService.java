package com.example.demo.service;

import com.example.demo.domain.User;

/**
 * Auth: yucheng
 * Date: 2018/9/6
 * Desc:
 */
public interface HelloService {
    User getUserById(Long id);

    int deleteUserById(Long id);
}
