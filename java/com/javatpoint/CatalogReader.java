package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogReader {

    public List<Catalog> getAllCatalogs() {
        List<Catalog> catalogs = new ArrayList<>();

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/discount", "root", "12345");

            // Prepare the SQL statement
            String sql = "SELECT catlog_id, catlog_name, catlog_dis FROM catlog";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String catalogId = resultSet.getString("catlog_id");
                String catalogName = resultSet.getString("catlog_name");
                String catalogDis = resultSet.getString("catlog_dis");

                Catalog catalog = new Catalog(catalogId, catalogName, catalogDis);
                catalogs.add(catalog);
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return catalogs;
    }
}
