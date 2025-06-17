package com.example.firstapp.dao;

import com.example.firstapp.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LanguageDao {
    private DataSource dataSource;

    @Autowired
    public LanguageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Language> getAll(){
        List<Language > languages = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM language");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()){
                languages.add(new Language(
                        resultSet.getString("name"),
                        resultSet.getInt("language_id")));
            }
        } catch (SQLException e){

            System.out.println(e.getMessage());
        }

        return languages;
    }

    public Language getById(int id){
        Language languages = null;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM language WHERE language_id = ?");
        ) {
            preparedStatement.setInt(1,id);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {


                if (resultSet.next()){
                    languages = new Language(resultSet.getString("name"), resultSet.getInt("language_id"));
                }
            }
        } catch (SQLException e){

            System.out.println(e.getMessage());
        }

        return languages;
    }

    public Language getByName(String name){
        Language languages = null;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM language WHERE name = ?");
        ) {
            preparedStatement.setString(1,name);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {

                if (resultSet.next()){
                    languages = new Language(resultSet.getString("name"), resultSet.getInt("language_id"));
                }
            }
        } catch (SQLException e){

            System.out.println(e.getMessage());
        }

        return languages;
    }

}