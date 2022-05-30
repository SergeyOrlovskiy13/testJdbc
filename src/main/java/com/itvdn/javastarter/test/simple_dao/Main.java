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



        User user1 = new User();
        user1.setUserAge(30);
        user1.setUserName("Alex");
        user1.setStatus(Status.ACTIVE);
        user1.setAddress(new Address("Mira", 22));
        List<String> phones = new ArrayList<>();
        phones.add("111222333");
        phones.add("333222444");
        user1.setUserPhone(phones);


        clientDAO.add(user1);

        System.out.println(user1);


    }

}
