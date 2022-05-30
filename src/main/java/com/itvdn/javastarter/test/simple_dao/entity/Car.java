package com.itvdn.javastarter.test.simple_dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private long id;
    private String mark;
    private String model;
    private int price;


}
