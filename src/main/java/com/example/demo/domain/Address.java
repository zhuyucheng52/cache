package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Auth: yucheng
 * Date: 2018/9/18
 * Desc:
 */
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = 3857390468091324155L;
    private String zip;
    private String province;
}
