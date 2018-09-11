package com.example.demo.database;


import com.example.demo.models.Login;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {
    String firstName, lastName, gender;
    String eMail, userName, password;
    String docName, specialization, day, time;


    public Connection createConnection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","iHateyou7");

        }catch (Exception e){
            System.out.println(e);
            System.out.println("inside Create connection");
        }
        return connection;

    }


    public Map getUser(Connection connection, Login login) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select username,password FROM userdata WHERE username = (?)");
            preparedStatement.setString(1, login.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                userName = resultSet.getString("userName");
                password = resultSet.getString("password");
            }
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("inside getvalue");
        }

        Map hashMap = new HashMap();
        hashMap.put("userName", userName);
        hashMap.put("password", password);

        return hashMap;


    }}