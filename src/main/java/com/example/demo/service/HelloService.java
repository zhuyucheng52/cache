package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.domain.User;

import java.util.List;

/**
 * Auth: yucheng
 * Date: 2018/9/6
 * Desc:
 */
public interface HelloService {
    User getUserById(Long id);

    int deleteUserById(Long id);

    void deleteUsers();

    List<Address> getAddress();
}
