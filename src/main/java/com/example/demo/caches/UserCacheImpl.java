package com.example.demo.caches;

import com.example.demo.domain.User;
import com.sun.istack.internal.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Auth: yucheng
 * Date: 2018/9/18
 * Desc:
 */
@Slf4j
@Component
@CacheConfig(cacheNames = "idUserCache")
public class UserCacheImpl implements UserCache {
    @Autowired
    private CacheManager cacheManager;

    @Override
    @Cacheable(key = "#p0")
    public User getUserById(Long id) {
        log.info("Get user by id: {}", id);
        return generateUser(id);
    }

    @Override
    @CacheEvict(key = "#p0")
    public int deleteUserById(Long id) {
        log.info("Delete user by id: {}", id);
        return 0;
    }

    @Override
    public void clear() {
        Cache cache = cacheManager.getCache("idUserCache");
        if (null != cache) {
            log.info("Clear cache idUserCache");
            cache.clear();
        } else {
            log.warn("Clear cache idUserCache is not exists");
        }
    }

    private static final User generateUser(@Nullable Long id) {
        try {
            log.info("Query user by id: {} from a busy rds...", id);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.warn("Sleep error", e);
        }

        User u = new User();
        u.setId(id);
        u.setName(null != id ? id + "" : "abc");
        u.setAge(18);
        u.setAddress("延平门");
        u.setPhone("110");

        return u;
    }
}
