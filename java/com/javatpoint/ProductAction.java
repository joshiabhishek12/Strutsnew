package com.javatpoint;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial", "unused" })
public class ProductAction extends ActionSupport {
    private int id;
    private String name;
    private float price;
    private int autoId;
    private List<String> catalogList;
    

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

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public List<String> getCatlogList() {
        return catalogList;
    }

    public void setCatalogList(List<String> catalogList) {
        this.catalogList = catalogList;
    }
    

    public String updateProduct() {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;
        ResultSet resultSet = null;

        try {
            if (name == null || name.trim().isEmpty()) {
                addFieldError("name", "Product Name is required");
            }

            if (price == 0) {
                addFieldError("price", "Product Price is required");
            } else {
                try {
                    price = Float.parseFloat(String.valueOf(price));
                } catch (NumberFormatException e) {
                    addFieldError("price", "Invalid Product Price. Please enter a numeric value.");
                }
            }

            if (hasFieldErrors()) {
                return INPUT;
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");

            String selectQuery = "SELECT * FROM product WHERE id = ?";
            selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, id);

            resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                // Update existing product
                String updateQuery = "UPDATE product SET name = ?, price = ? WHERE id = ?";
                updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, name);
                updateStatement.setFloat(2, price);
                updateStatement.setInt(3, id);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    return SUCCESS;
                } else {
                    addActionError("Failed to update product");
                    return ERROR;
                }
            } else {
                addActionError("Product not found");
                return ERROR;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            addActionError("An error occurred while updating product");
            return ERROR;
        } finally {
            // Close resources in the finally block
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (updateStatement != null) {
                try {
                    updateStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public String execute() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            if (name == null || name.trim().isEmpty()) {
                addFieldError("name", "Product Name is required");
            }

            if (price == 0) {
                addFieldError("price", "Product Price is required");
            } else {
                try {
                    price = Float.parseFloat(String.valueOf(price));
                } catch (NumberFormatException e) {
                    addFieldError("price", "Invalid Product Price. Please enter a numeric value.");
                }
            }

            if (hasFieldErrors()) {
                return INPUT;
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");

            String query = "INSERT INTO product (name, price) VALUES (?, ?)";
            statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setFloat(2, price);

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                autoId = resultSet.getInt(1);
                setId(autoId); // Set the auto-generated ID to the ID property
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String deleteProduct() {
        boolean confirmDelete = showConfirmationDialog();
        if (!confirmDelete) {
            addActionMessage("Product deletion canceled");
            return SUCCESS;
        }

        Connection connection = null;
        PreparedStatement deleteStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "12345");

            String deleteQuery = "DELETE FROM product WHERE id = ?";
            deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, id);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected > 0) {
                addActionMessage("Product deleted successfully");
                return SUCCESS;
            } else {
                addActionError("Failed to delete product");
                return ERROR;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            addActionError("An error occurred while deleting product");
            return ERROR;
        } finally {
            if (deleteStatement != null) {
                try {
                    deleteStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean showConfirmationDialog() {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?", "Confirmation", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
    
    public List<String> getCatalogList() {
        List<String> catalogList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/discount", "root", "12345");

            String sql = "SELECT catlog_name FROM catlog";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String catalogName = resultSet.getString("catlog_name");
                catalogList.add(catalogName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return catalogList;
    }
}
