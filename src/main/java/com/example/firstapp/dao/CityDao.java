package com.example.firstapp.dao;

import com.example.firstapp.model.City;
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
public class CityDao {
    private DataSource dataSource;

    @Autowired
    public CityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<City> getAll(){
        List<City > cities = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM city");
                ResultSet resultSet = preparedStatement.executeQuery();
                ) {

            while (resultSet.next()){
                cities.add(new City(resultSet.getString("city"),resultSet.getInt("country_id")));
            }
        } catch (SQLException e){

            System.out.println(e.getMessage());
        }

        return cities;
    }
}
