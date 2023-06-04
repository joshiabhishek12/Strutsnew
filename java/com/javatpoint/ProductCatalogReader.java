package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalogReader {
    public List<PC> getProductList() {
        List<PC> productCatalogList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");
            String dbQuery = "SELECT id, name, price FROM product";
            PreparedStatement dbStatement = dbConnection.prepareStatement(dbQuery);
            ResultSet dbResultSet = dbStatement.executeQuery();

           
            Connection discountConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/discount", "root", "12345");
            String discountQuery = "SELECT catlog_id, catlog_name, catlog_dis FROM catlog";
            PreparedStatement discountStatement = discountConnection.prepareStatement(discountQuery);
            ResultSet discountResultSet = discountStatement.executeQuery();

            while (dbResultSet.next() && discountResultSet.next()) {
                int productId = dbResultSet.getInt("id");
                String productName = dbResultSet.getString("name");
                float productPrice = dbResultSet.getFloat("price");
                String catalogId = discountResultSet.getString("catlog_id");
                String catalogName = discountResultSet.getString("catlog_name");
                String catalogDis = discountResultSet.getString("catlog_dis");

                PC productCatalog = new PC(productId, productName, productPrice,
                        catalogId, catalogName, catalogDis);
                productCatalogList.add(productCatalog);
            }

            dbResultSet.close();
            dbStatement.close();
            dbConnection.close();

            discountResultSet.close();
            discountStatement.close();
            discountConnection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return productCatalogList;
    }
}
