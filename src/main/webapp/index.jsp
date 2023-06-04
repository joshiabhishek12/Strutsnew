<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.javatpoint.ReadValue" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.Product" %>
<%@ page import="com.javatpoint.CatalogReader" %>
<%@ page import="com.javatpoint.Catalog" %>

<%
    CatalogReader catalogReader = new CatalogReader();
    List<Catalog> catalogs = catalogReader.getAllCatalogs();
    request.setAttribute("catalogs", catalogs);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Shopping Website</title>
    <style>
        body 
               {
	background-image:
		url('https://www.tendencias.kpmg.es/wp-content/uploads/2018/11/GettyImages-912949110.jpg');
	background-repeat: no-repeat;
	/* Choose from 'repeat', 'repeat-x', 'repeat-y', or 'no-repeat' */
	background-size: 100% auto;
}
        
        {
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

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            color: #555;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s ease;
        }

        .form-group input[type="text"]:focus,
        .form-group select:focus {
            outline: none;
            border-color: #80bdff;
        }

        .form-actions {
            text-align: center;
            margin-top: 20px;
        }

        .form-actions input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-actions input[type="submit"]:hover {
            background-color: #555;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .table th,
        .table td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        .table th {
            background-color: #f0f0f0;
            font-weight: bold;
        }

        .table a {
            text-decoration: none;
            display: inline-block;
            padding: 5px 10px;
            border-radius: 3px;
            transition: background-color 0.3s ease;
        }

        .table a.edit-link {
            background-color: #4caf50;
            color: #fff;
        }

        .table a.delete-link {
            background-color: #f44336;
            color: #fff;
        }

        .table a.edit-link:hover,
        .table a.delete-link:hover {
            background-color: #333;
        }

        .discount-link {
            margin-top: 20px;
            text-align: center;
        }

        .discount-link a {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .discount-link a:hover {
            background-color: #555;
        }

        .navigation-links {
            margin-top: 20px;
            text-align: center;
        }

        .navigation-links a {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .navigation-links a:hover {
            background-color: #555;
        }

        .footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
            margin-top: 20px;
        }

        .footer a {
            color: #fff;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>Shopping Website</h1>

    <div class="container">
        <s:form action="product">
              <s:hidden name="id" value="%{autoId}" /> <!-- Display the auto-generated ID -->

    <s:textfield name="name" label="Product Name" />
    <s:textfield name="price" label="Product Price" />
    

            <div class="form-group">
                <label for="catalog_name">Catalog Name:</label>
                <select id="catalog_name" name="catalog_name">
                    <option value="">Select</option>
                    <% for (Catalog catalog : catalogs) { %>
                        <option value="<%= catalog.getCatlog_name() %>"><%= catalog.getCatlog_name() %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-actions">
                <s:submit value="Save" />
                <s:actionerror />
            </div>
        </s:form>

        <table class="table">
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <% ReadValue readValue = new ReadValue();
               List<Product> productList = readValue.getProductList();

               for (Product product : productList) {
            %>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><a href="edit.action?id=<%= product.getId() %>" class="edit-link">Edit</a></td>
                    <td><a href="delete.action?id=<%= product.getId() %>" class="delete-link">Delete</a></td>
                </tr>
            <% } %>
        </table>

        <div class="discount-link">
            <a href="discount.action">50% Discount Hurry up!</a>
        </div>

        <div class="navigation-links">
            <a href="orderdetail.jsp">Order Detail</a>
            <a href="hello.jsp">Catalog</a>
            <a href="productcatalogjoin.jsp">Catalog Product</a>
        </div>
    </div>

    <div class="footer">
        <a href="https://www.bing.com/search?q=impaqx+mysore&cvid=1f861a72e1e9408da1b4f5c387bd281d&aqs=edge..69i57j69i64.38279j0j9&FORM=ANAB01&PC=HCTS">Learn More About Our Company</a>
    </div>
</body>
</html>
