package com.example.demo.service;

import com.example.demo.caches.AddressCache;
import com.example.demo.caches.UserCache;
import com.example.demo.domain.Address;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Auth: yucheng
 * Date: 2018/9/6
 * Desc:
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UserCache userCache;

    @Autowired
    private AddressCache addressCache;


    @Override
    public User getUserById(Long id) {
        return userCache.getUserById(id);
    }

    @Override
    public int deleteUserById(Long id) {
        return userCache.deleteUserById(id);
    }

    @Override
    public void deleteUsers() {
        userCache.clear();
    }

    @Override
    public List<Address> getAddress() {
        return addressCache.getAddresses();
    }

    @Override
    public void deleteAddress() {
        addressCache.clear();
    }

}
