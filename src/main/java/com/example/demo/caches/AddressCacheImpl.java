package com.example.demo.caches;

import com.example.demo.domain.Address;
import lombok.extern.slf4j.Slf4j;
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
    @Override
    @Cacheable
    public List<Address> getAddresses() {
        log.info("Get all addresses");
        return generateAddresList((int) (Math.random() * 10));
    }

    private List<Address> generateAddresList(int i) {
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
