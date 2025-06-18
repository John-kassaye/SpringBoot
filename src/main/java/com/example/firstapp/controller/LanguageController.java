package com.example.firstapp.controller;

import com.example.firstapp.dao.LanguageDao;
import com.example.firstapp.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController {
    private LanguageDao languageDao;

    @Autowired
    public LanguageController(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @GetMapping("Hi")
    public String language(){
        return "Hola!";
    }

    @GetMapping("Hi/{name}")
    public String language(@PathVariable String name){
        return "Hola! " + name;
    }

    @GetMapping("Languages")
    public List<Language> languages(){
        return languageDao.getAll();
    }

    @GetMapping("Language/{id}")
    public Language languageById( @PathVariable int id){
        return languageDao.getById(id);
    }

    @GetMapping("Language/{name}")
    public Language languageByName( @PathVariable String name){
        return languageDao.getByName(name);
    }
}
