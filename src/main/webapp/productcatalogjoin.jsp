<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.PC" %>
<%@ page import="com.javatpoint.ProductCatalogReader" %>
<html>
<head>
    <title>Product Catalog</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
         
            background-image: url('https://moneysavingcentral.co.uk/images/clothes-sale-dates.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        

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
    <h1>Product Catalog</h1>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Category ID</th>
            <th>Category Name</th>
            <th>Category Description</th>
        </tr>

        <% 
            com.javatpoint.ProductCatalogReader reader = new com.javatpoint.ProductCatalogReader();
            List<com.javatpoint.PC> productCatalogList = reader.getProductList();

            for (com.javatpoint.PC productCatalog : productCatalogList) {
        %>
            <tr>
                <td><%= productCatalog.getProductId() %></td>
                <td><%= productCatalog.getProductName() %></td>
                <td><%= productCatalog.getProductPrice() %></td>
                <td><%= productCatalog.getCatalogId() %></td>
                <td><%= productCatalog.getCatalogName() %></td>
                <td><%= productCatalog.getCatalogDis() %></td>
            </tr>
        <% 
            }
        %>
    </table>
</body>
</html>
