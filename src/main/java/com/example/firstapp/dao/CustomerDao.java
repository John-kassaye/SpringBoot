package com.example.firstapp.dao;

import com.example.firstapp.model.Customer;
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
public class CustomerDao {
    private DataSource dataSource;

    @Autowired
    public CustomerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Customer> getAll(){
        List<Customer> customers = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
                ResultSet resultSet = preparedStatement.executeQuery();
                ) {
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getInt("customer_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("address_id"),
                        resultSet.getBoolean("active")));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }


        return customers;
    }

    public List<Customer> getById(int id){
        List<Customer> customers = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE customer_id = ?;")
        ) {
            preparedStatement.setInt(1,id);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()){
                    customers.add(new Customer(resultSet.getInt("customer_id"),
                            resultSet.getInt("store_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getInt("address_id"),
                            resultSet.getBoolean("active")));
                }
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public List<Customer> getByFirstName(String firstName){
        List<Customer> customers = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE first_name = ?;")
                ) {
            preparedStatement.setString(1,firstName);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
                    ) {
                while (resultSet.next()){
                    customers.add(new Customer(resultSet.getInt("customer_id"),
                            resultSet.getInt("store_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getInt("address_id"),
                            resultSet.getBoolean("active")));
                }
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public List<Customer> getByLastName(String lastName){
        List<Customer> customers = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE last_name = ?;")
        ) {
            preparedStatement.setString(1,lastName);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()){
                    customers.add(new Customer(resultSet.getInt("customer_id"),
                            resultSet.getInt("store_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getInt("address_id"),
                            resultSet.getBoolean("active")));
                }
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public List<Customer> getByAddressId(int addressID){
        List<Customer> customers = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE address_id = ?;")
        ) {
            preparedStatement.setInt(1,addressID);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()){
                    customers.add(new Customer(resultSet.getInt("customer_id"),
                            resultSet.getInt("store_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getInt("address_id"),
                            resultSet.getBoolean("active")));
                }
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return customers;
    }
}
