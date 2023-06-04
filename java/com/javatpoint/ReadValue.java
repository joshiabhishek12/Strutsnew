package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadValue {
    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");

            String query = "SELECT * FROM product";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                float productPrice = resultSet.getFloat("price");

                Product product = new Product(productId, productName, productPrice);
                productList.add(product);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
}
