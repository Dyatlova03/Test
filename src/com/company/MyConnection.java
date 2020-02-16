package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private Connection connection;
    public MyConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema",
                    "postgres", "postgres");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
