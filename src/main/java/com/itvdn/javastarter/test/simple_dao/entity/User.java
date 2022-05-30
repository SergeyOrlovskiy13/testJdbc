package com.itvdn.javastarter.test.simple_dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long userId;
    private String userName;
    private int userAge;
    private List<String> userPhone;     // в таблице phone хранить колонку с id юзера
    private List<Car> userCars;          // отдельно таблицу с id клиентами и id машинами
    private Address address;          //в бд будет id street
    private Status status;

}



