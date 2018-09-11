package com.example.demo.repositories;
import com.example.demo.database.DatabaseConnection;
import com.example.demo.models.Login;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Map;

@Repository
public class LoginRepository {

    public Map checkLogin(Login login) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.createConnection();
        Map hashMap = databaseConnection.getUser(connection, login);
        return hashMap;

    }}
