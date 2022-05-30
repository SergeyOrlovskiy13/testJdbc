package com.itvdn.javastarter.test.simple_dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private long addressId;
    private long userId;
    private String nameStreet;
    private int numberHome;

    public Address(String nameStreet, int numberHome) {
        this.nameStreet = nameStreet;
        this.numberHome = numberHome;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", nameStreet='" + nameStreet + '\'' +
                ", numberHome=" + numberHome +
                '}';
    }
}
