package com.company;

import domain.Film;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;


public class FilmRepository {

    MyConnection myConnection = new MyConnection();

    public Collection<Film> getAllFilms() {

        List allFilms = new ArrayList();
        try {
            String select = "SELECT * FROM film";
            Statement statement = myConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {
                allFilms.add(new Film(resultSet.getInt("id"), resultSet.getInt("director_id"),
                        resultSet.getString("name"),
                        resultSet.getDate("release_date"), resultSet.getString("genre")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allFilms;
    }

    public Collection<Film> getFilmsByDate(Date date) throws SQLException {

        List filmByDate = new ArrayList();
        Statement statement = myConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM film WHERE release_date >= " + "'" + date + "'");

        while (resultSet.next()) {

            filmByDate.add(new Film(resultSet.getInt("id"), resultSet.getInt("director_id"),
                    resultSet.getString("name"), resultSet.getDate("release_date"),
                    resultSet.getString("genre")));
            resultSet.next();
        }
        return filmByDate;
    }

    public Collection<Film> getFilmByDateAndId(int id, Date date) {
        String select = "SELECT * FROM film WHERE director_id = " + id + " AND release_date >= " + "'" + date + "'";
        List<Film> films = new ArrayList<>();
        try {
            Statement statement = myConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                films.add(new Film(resultSet.getInt("id"), resultSet.getInt("director_id"),
                        resultSet.getString("name"), resultSet.getDate("release_date"),
                        resultSet.getString("genre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}
