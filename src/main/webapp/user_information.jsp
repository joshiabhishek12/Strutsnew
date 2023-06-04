<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        .footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        .content {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        .red-button {
            background-color: #ff0000;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        .brown-heading {
            color: #8b4513;
            margin-top: 40px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Welcome to our Online Store</h1>
    </div>

    <div class="content">
        <h2>Provide User Information</h2>
        <s:form action="submitOrder">
            <s:textfield name="id" label="Product ID: " value="%{id}" readonly="true" />
            <s:textfield name="productName" label="Product Name: " value="%{productName}" readonly="true" />
            <s:textfield name="price" label="Price: " value="%{price}" readonly="true" />
            <s:textfield name="userName" label="User Name: " />
            <s:textfield name="phoneNum" label="Phone Number: " />
            <s:textfield name="address" label="Address: " />
            <s:textfield name="adharCardNum" label="Aadhar Card Number: " />

            <s:submit value="CONFIRM YOUR ORDER" cssClass="red-button" />
        </s:form>
        <h2 class="brown-heading">Only Cash on Delivery is Available</h2>
    </div>

    <div class="footer">
        <p>&copy; 2023 Your Online Store. All rights reserved.</p>
    </div>
</body>
</html>
