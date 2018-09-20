package com.example.demo.caches;

import com.example.demo.domain.User;

/**
 * Auth: yucheng
 * Date: 2018/9/18
 * Desc:
 */
public interface UserCache {
    User getUserById(Long id);
    int deleteUserById(Long id);
    void clear();
}
