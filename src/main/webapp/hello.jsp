<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.CatalogReader" %>
<%@ page import="com.javatpoint.Catalog" %>

<html>
<head>
    <title>Display Catalogs</title>
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

        form {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
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
    <h1>Catalogs</h1>

    <%-- Retrieve catalogs from the database --%>
    <% CatalogReader catalogReader = new CatalogReader();
       List<Catalog> catalogs = catalogReader.getAllCatalogs();
    %>

    <%-- Display the catalog form --%>
    <form action="saveCatalog" method="post">
        <label for="catlog_id">Catalog ID:</label>
        <input type="text" id="catlog_id" name="catlog_id" required><br><br>

        <label for="catlog_name">Catalog Name:</label>
        <input type="text" id="catlog_name" name="catlog_name" required><br><br>

        <label for="catlog_dis">Catalog Description:</label>
        <input type="text" id="catlog_dis" name="catlog_dis" required><br><br>

        <input type="submit" value="Submit">
    </form>

    <%-- Display catalogs --%>
    <table>
        <tr>
            <th>Catalog ID</th>
            <th>Catalog Name</th>
            <th>Catalog Description</th>
        </tr>
        <% for (Catalog catalog : catalogs) { %>
            <tr>
                <td><%= catalog.getCatlog_id() %></td>
                <td><%= catalog.getCatlog_name() %></td>
                <td><%= catalog.getCatlog_dis() %></td>
            </tr>
        <% } %>
    </table>

</body>
</html>
