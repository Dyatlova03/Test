package com.company;

import domain.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DirectorRepository {

    MyConnection myConnection = new MyConnection();

    public Collection<Director> getAllDirectors() {

        List allDirectors = new ArrayList();
        String select = "SELECT * FROM director";
        try {
            Statement statement = myConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {
                allDirectors.add(new Director(resultSet.getInt("id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("birth_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDirectors;
    }

    public Director getDirectorById(int id) {
        Director directorById = null;
        try {
            Statement statement = myConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM director WHERE id = " + id);
            if (resultSet.next()) {
                directorById = new Director(resultSet.getInt("id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getDate("birth_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directorById;
    }
}
