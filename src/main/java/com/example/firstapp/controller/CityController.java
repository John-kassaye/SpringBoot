package com.example.firstapp.controller;

import com.example.firstapp.dao.CityDao;
import com.example.firstapp.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private CityDao cityDao;

    @Autowired
    public CityController(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @GetMapping("hi")
    public String example(){
        return "Hello";
    }

    @GetMapping("hi/{name}")
    public String example2(@PathVariable String name){
        return "Hi" + name;
    }

    @GetMapping("cities")
    public List<City> getCities(){
        return cityDao.getAll();
    }
}
