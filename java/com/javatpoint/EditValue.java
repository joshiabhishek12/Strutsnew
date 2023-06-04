package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditValue {
    private int id;
    private String name;
    private float price;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product getProductById(int productId) {
        Product product = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");

            String query = "SELECT * FROM product WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");

                product = new Product(id, name, price);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public String execute() {
        if (id == 0) {
            // Handle the case when id is not provided
            return "error";
        }

        Product product = getProductById(id);

        if (product == null) {
            // Handle the case when product is not found
            return "error";
        }

        // Update the product details
        product.setName(name);
        product.setPrice(price);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");

            String query = "UPDATE product SET name = ?, price = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getId());

            int rowsUpdated = statement.executeUpdate();

            statement.close();
            connection.close();

            if (rowsUpdated > 0) {
                return "success";
            } else {
                // Handle the case when update fails
                return "error";
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
