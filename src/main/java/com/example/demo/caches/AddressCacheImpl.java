package com.example.demo.caches;

import com.example.demo.domain.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Auth: yucheng
 * Date: 2018/9/20
 * Desc:
 */
@Slf4j
@Component
@CacheConfig(cacheNames = "addressCache")
public class AddressCacheImpl implements AddressCache {
    @Autowired
    private CacheManager cacheManager;

    @Override
    @Cacheable
    public List<Address> getAddresses() {
        log.info("Get all addresses");
        return generateAddressList((int) (Math.random() * 10));
    }

    @Override
    public void clear() {
        Cache cache = cacheManager.getCache("addressCache");
        if (null != cache) {
            log.info("Clearn cache addressCache");
            cache.clear();
        } else {
            log.warn("Clearn cache addressCache is not exists");
        }
    }

    private List<Address> generateAddressList(int i) {
        List<Address> addresses = new ArrayList<Address>(i);
        for (int j = 0; j < i; ++j) {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Address address = new Address();
            address.setProvince("province" + j);
            address.setZip("zip" + j);
            addresses.add(address);
        }

        return addresses;
    }
}
