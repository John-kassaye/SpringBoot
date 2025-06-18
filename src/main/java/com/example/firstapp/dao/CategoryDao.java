package com.example.firstapp.dao;

import com.example.firstapp.model.Category;
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
public class CategoryDao {
    private DataSource dataSource;
    @Autowired
    public CategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Category> getAll(){
        List<Category> categoryList = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Categories");
                ResultSet resultSet = preparedStatement.executeQuery();
                ){
            while (resultSet.next()){
                categoryList.add(new Category(
                        resultSet.getInt("CategoryId"),
                        resultSet.getString("CategoryName"),
                        resultSet.getString("Description"))
                );
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return categoryList;
    }

    public Category getByID(int id){
        Category category = null;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM Categories WHERE CategoryId = ?")
                ){
            preparedStatement.setInt(1,id);
            try ( ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    category = new Category(
                            resultSet.getInt("CategoryId"),
                            resultSet.getString("CategoryName"),
                            resultSet.getString("Description"));
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return category;
    }

    public String addCategory(Category category){
        String message = "Error";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Categories(CategoryId,CategoryName,Description) VALUES (?,?,?)");

                ){
            preparedStatement.setInt(1,category.getId());
            preparedStatement.setString(2,category.getCategoryName());
            preparedStatement.setString(3,category.getDescription());

            int affectRow = preparedStatement.executeUpdate();
            if (affectRow == 1){
                message = "Successfully added!";
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return message;
    }

    public String updateCategory(Category category, int id){
        String message = "Error";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Categories SET CategoryName = ?," +
                        " Description = ? WHERE CategoryName = ?;")
                ){
            preparedStatement.setString(1,category.getCategoryName());
            preparedStatement.setString(2,category.getDescription());
            preparedStatement.setInt(3,id);

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1){
                message = "Successfully updated!";
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return message;
    }

    public String deleteCategory(int id){
        String message = "Error";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Categories WHERE CategoryId = ?;")
                ){
            preparedStatement.setInt(1,id);

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1){
                message = "Successfully deleted!";
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return message;
    }
}
