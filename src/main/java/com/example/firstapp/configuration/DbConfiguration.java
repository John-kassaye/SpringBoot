package com.example.firstapp.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DbConfiguration {
    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        String userName = "root";
        String password = "root";
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        return dataSource;
    }
}
