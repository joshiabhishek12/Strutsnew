package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CatalogAction {

    private String catlog_id;
    private String catlog_name;
    private String catlog_dis;

    public String execute() {
        return "success";
    }

    public String saveCatalog() {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/discount", "root", "12345");

            // Prepare the SQL statement
            String sql = "INSERT INTO catlog (catlog_id, catlog_name, catlog_dis) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, catlog_id);
            statement.setString(2, catlog_name);
            statement.setString(3, catlog_dis);

            // Execute the statement
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String getCatlog_id() {
        return catlog_id;
    }

    public void setCatlog_id(String catlog_id) {
        this.catlog_id = catlog_id;
    }

    public String getCatlog_name() {
        return catlog_name;
    }

    public void setCatlog_name(String catlog_name) {
        this.catlog_name = catlog_name;
    }

    public String getCatlog_dis() {
        return catlog_dis;
    }

    public void setCatlog_dis(String catlog_dis) {
        this.catlog_dis = catlog_dis;
    }
}
