package com.itvdn.javastarter.test.simple_dao;

import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.dao.impl.DAOFactory;
import com.itvdn.javastarter.test.simple_dao.dao.IDAOFactory;
import com.itvdn.javastarter.test.simple_dao.entity.Address;
import com.itvdn.javastarter.test.simple_dao.entity.Status;
import com.itvdn.javastarter.test.simple_dao.entity.User;

import java.util.ArrayList;
import java.util.List;

public class  Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();

        ClientDAO clientDAO = factory.getClientDAO();



        User user2 = new User();
        user2.setUserAge(30);
        user2.setUserName("Alex");
        user2.setStatus(Status.ACTIVE);
        user2.setAddress(new Address("Mira", 22));
        List<String> phones = new ArrayList<>();
        phones.add("111222333");
        phones.add("333222444");
        user2.setUserPhone(phones);


        clientDAO.add(user2);

        System.out.println(user2);


    }

}
