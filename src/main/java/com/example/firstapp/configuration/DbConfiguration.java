package com.example.firstapp.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DbConfiguration {

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

    @Value("${db.url}")
    private String url;
    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }
}
