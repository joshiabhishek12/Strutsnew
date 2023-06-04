package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountReader {
    public List<Detail> getOrderDetails() {
        List<Detail> orderDetails = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/discount", "root", "12345")) {
            String query = "SELECT * FROM detail";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String id = resultSet.getString("product_id");
                    String productName = resultSet.getString("product_name");
                    float price = resultSet.getFloat("price");
                    String userName = resultSet.getString("user_name");
                    String phoneNum = resultSet.getString("phone_number");
                    String address = resultSet.getString("address");
                    String adharCardNum = resultSet.getString("aadhar_card_number");

                    Detail detail = new Detail(id, productName, price, userName, phoneNum, address, adharCardNum);
                    orderDetails.add(detail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetails;
    }
}

