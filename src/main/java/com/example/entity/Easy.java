package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tenpaper
 * @date 2020/12/2 14:37
 */
@Data
public class Easy implements Serializable {

    private static final long serialVersionUID = 8439971382761951176L;

    private String name;

    private String age;
}
