package com.itvdn.javastarter.test.simple_dao.dao.impl;

import com.itvdn.javastarter.test.conection.MyConnection;
import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.entity.Address;
import com.itvdn.javastarter.test.simple_dao.entity.User;

import java.sql.*;
import java.util.List;

public class ClientJDBCDao implements ClientDAO {
    /*@Override
    public void add(User user) {*/

    /* Connection connection = MyConnection.getConnection();

     PreparedStatement statement;

     try {
         int streetId = getStreetId(user.getAddress(), connection);
         boolean isUser = isUser(user, connection);

         if (streetId == -1) {
             statement = connection.prepareStatement("INSERT INTO street(street_name) VALUES (?)");
             statement.setString(1, user.getAddress());
             statement.execute();
             statement = connection.prepareStatement("SELECT MAX(street_id) FROM street");
             ResultSet rs = statement.executeQuery();
             rs.next();
             streetId = rs.getInt(1);
         }
         if (!isUser) {
             statement = connection.prepareStatement("INSERT INTO users (name, age, street_id) VALUES (?, ?, ?)");

             statement.setString(1, user.getUserName());
             statement.setInt(2, user.getUserAge());
             statement.setInt(3, streetId);
             //statement.set

             statement.execute();
             statement = connection.prepareStatement("SELECT MAX(id) FROM clients");
             ResultSet resultSet = statement.executeQuery();
             int idLastClient = 0;
             if (resultSet.next()) {
                 idLastClient = resultSet.getInt(1);
             }
             resultSet.next();*/
///
    @Override
    public void add(User user) {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps;

        try {
            // проверка есть ли такой юзер
            if (!isUser(user, connection)) {
                try {
                    ps = connection.prepareStatement("insert into users(user_name, user_age, status) value (?,?,?)");
                    ps.setString(1, user.getUserName());
                    ps.setInt(2, user.getUserAge());
                    ps.setString(3, user.getStatus().toString());
                    ps.execute();

                    ps = connection.prepareStatement("select max(user_id) from users");
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    long userId = rs.getLong(1);
                    user.setUserId(userId);
                } catch (Exception ex) {
                }
            }

            if (!isAddress(user.getAddress(), connection)) {
                try {
                    ps = connection.prepareStatement("insert into address (user_id, street_name, number_home) value (?,?,?)");
                    ps.setLong(1, user.getUserId());
                    ps.setString(2, user.getAddress().getNameStreet());
                    ps.setInt(3, user.getAddress().getNumberHome());
                    ps.execute();

                } catch (Exception ex) {
                }
            }


            List<String> phones = user.getUserPhone();
            for (String p : phones) {
                ps = connection.prepareStatement("INSERT INTO phone (phone_number, user_id) VALUES (?, ?)");
                ps.setString(1, p);
                ps.setLong(2, user.getUserId());
                ps.execute();
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }


    @Override
    public User getById(int id) {

       /* PreparedStatement preparedStatement = null;


        Connection connection = MyConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT c.name, c.age, s.street_name FROM users as c " +

                    "INNER JOIN street as s ON s.street_id = c.street_id" +
                    "WHERE c.id = ? ");

            preparedStatement.setInt(1, id);


            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString(1);
                int age = rs.getInt(2);
                String streetName = rs.getString(3);


                User user = new User();
                user.setUserId(id);
                user.setUserName(name);
                user.setUserAge(age);
                user.setAddress(streetName);
                user.setUserPhone(getPhoneByIdClient(id, connection));
                return user;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/

        return null;
    }

    @Override
    public void updateNameAndAge(String name, int age) {

    }

    @Override
    public void remove(String name) {

    }

    private List<String> getPhoneByIdClient(int id, Connection connection) {
        List<String> phoneList = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT phone_number FROM phone WHERE client_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                phoneList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phoneList;

    }


    private int getStreetId(String streetName, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT street_id FROM street WHERE street_name = ? ");
            preparedStatement.setString(1, streetName);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private boolean isAddress(Address address, Connection connection) {

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM address WHERE street_name = ? AND number_home = ?");
            ps.setString(1, address.getNameStreet());
            ps.setInt(2, address.getNumberHome());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isUser(User user, Connection connection) {

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT user_id FROM users WHERE user_name = ? AND user_age = ?");
            ps.setString(1, user.getUserName());
            ps.setInt(2, user.getUserAge());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private long getClientId(String clientName, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM clients WHERE name = ? ");
            preparedStatement.setString(1, clientName);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

}
