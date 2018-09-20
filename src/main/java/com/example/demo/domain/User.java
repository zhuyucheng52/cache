package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Auth: yucheng
 * Date: 2018/9/6
 * Desc:
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -3828523224891480517L;

    private Long id;
    private String name;
    private int age;
    private String address;
    private String phone;
}
