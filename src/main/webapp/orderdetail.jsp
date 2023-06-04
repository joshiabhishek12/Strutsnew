<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.DiscountReader" %>
<%@ page import="com.javatpoint.Detail" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
       <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            padding: 20px;
            background-color: #333;
            color: #fff;
            margin: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #f0f0f0;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h1>Order Details</h1>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>User Name</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Aadhar Card Number</th>
        </tr>
        <% 
            DiscountReader discountDAO = new DiscountReader();
            List<Detail> orderDetails = discountDAO.getOrderDetails();
            for (Detail detail : orderDetails) {
        %>
        <tr>
            <td><%= detail.getId() %></td>
            <td><%= detail.getProductName() %></td>
            <td><%= detail.getPrice() %></td>
            <td><%= detail.getUserName() %></td>
            <td><%= detail.getPhoneNum() %></td>
            <td><%= detail.getAddress() %></td>
            <td><%= detail.getAdharCardNum() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
