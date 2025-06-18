package com.example.firstapp.controller;

import com.example.firstapp.dao.CategoryDao;
import com.example.firstapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("category")
    public List<Category> getAll(){
        return categoryDao.getAll();
    }

    @GetMapping("category/{id}")
    public Category getById(@PathVariable int id){
        return categoryDao.getByID(id);
    }

    @PostMapping("category")
    public String addCategory(@RequestBody Category category){
        return categoryDao.addCategory(category);
    }

    @PutMapping("category/{id}")
    public String updateCategory(@PathVariable int id, @RequestBody Category category){
        return categoryDao.updateCategory(category,id);
    }

    @DeleteMapping("category/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        return categoryDao.deleteCategory(id);
    }

}
