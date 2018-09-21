package com.example.demo.caches;

import com.example.demo.domain.Address;

import java.util.List;

/**
 * Auth: yucheng
 * Date: 2018/9/20
 * Desc:
 */
public interface AddressCache {
    List<Address> getAddresses();

    void clear();
}
