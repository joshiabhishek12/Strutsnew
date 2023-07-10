<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.javatpoint.ReadValue" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javatpoint.Product" %>
<%@ page import="com.javatpoint.CatalogReader" %>
<%@ page import="com.javatpoint.Catalog" %>

 <% CatalogReader catalogReader = new CatalogReader();
       List<Catalog> catalogs = catalogReader.getAllCatalogs();
    %>

<s:form action="product">
    <s:hidden name="id" value="%{autoId}" /> <!-- Display the auto-generated ID -->

    <s:textfield name="name" label="Product Name" />
    <s:textfield name="price" label="Product Price" />
     <label for="catlog_name">Catalog Name:</label>
     <select id="catlog_name" name="catlog_name" required>
            
            <% for (Catalog catalog : catalogs) { %>
                <option value="<%= catalog.getCatlog_name() %>"><%= catalog.getCatlog_name() %></option>
            <% } %>
                    </select><br><br>

   
    <s:submit value="Save" />
    <s:actionerror />

    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <%
            ReadValue readValue = new ReadValue();
            List<Product> productList = readValue.getProductList();

            for (Product product : productList) {
        %>
            <tbody>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><a href="edit.action?id=<%= product.getId() %>"><span style="color: green;">Edit</span></a></td>
                    <td><a href="delete.action?id=<%= product.getId() %>"><span style="color: red;">Delete</span></a></td>
                </tr>
            </tbody>
        <%
            }
        %>
    </table>
</s:form>

<!-- Separate section for "Heavy Discount" -->
<div style="margin-top: 20px; text-align: center;">
    <a href="discount.action">50% Discount Hurry up!</a>
    <a href="orderdetail.jsp">Orderdetail</a>
        
  <a href="hello.jsp">CATLOG</a>
  <a href="productcatalogjoin.jsp">CATALOG PRODUCT</a>
</div>

