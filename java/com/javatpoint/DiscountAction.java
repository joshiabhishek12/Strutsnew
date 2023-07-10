package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DiscountAction extends ActionSupport {
    private String id;
    private String productName;
    private float price;
    private String userName;
    private String phoneNum;
    private String address;
    private String adharCardNum;

    // Getters and Setters for the fields

    public String execute() {


        return SUCCESS;
    }

    public String search() {
        // Add your logic here to search for products based on the 'query'
        // Retrieve the relevant products and pass them to the JSP page for display
        // Example code:
        // List<Product> productList = productService.searchProducts(query);
        // setProducts(productList);

        return SUCCESS;
    }

    public String submitOrder() {
        
        if (userName == null || userName.trim().isEmpty()) {
            addFieldError("userName", "user Name is required.");
        }

        if (address == null || address.trim().isEmpty()) {
            addFieldError("address", "address is required.");
        }
        if (phoneNum == null || phoneNum.trim().isEmpty()) {
            addFieldError("phoneNum", "Phonenum is required.");
        }
        if (adharCardNum == null || adharCardNum.trim().isEmpty()) {
        	 addFieldError("adharCardNum", "adhar is required.");
        }
        

        if (hasFieldErrors()) {
            return INPUT;
        }


        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("User Name: " + userName);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("Address: " + address);
        System.out.println("Aadhar Card Number: " + adharCardNum);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/discount", "root", "12345")) {
            String query = "INSERT INTO detail (product_id, product_name, price, user_name, phone_number, address, aadhar_card_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, productName);
                statement.setFloat(3, price);
                statement.setString(4, userName);
                statement.setString(5, phoneNum);
                statement.setString(6, address);
                statement.setString(7, adharCardNum);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Order saved successfully.");
                    return SUCCESS;
                } else {
                    System.out.println("Failed to save order.");
                    return ERROR;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;


       if (id.equals("1")) {
            setProductName("Jeans");
            setPrice(500);
        } else if (id.equals("2")) {
            setProductName("Shirt");
            setPrice(700);
        } else if (id.equals("3")) {
            setProductName("Sneaker");
            setPrice(1000);
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdharCardNum() {
        return adharCardNum;
    }

    public void setAdharCardNum(String adharCardNum) {
        this.adharCardNum = adharCardNum;
    }
}
