<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
       

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin-top: -50px;
        }
        
           body {
            background-image: url('https://moneysavingcentral.co.uk/images/clothes-sale-dates.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
         
         
         
         
         
         {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .form-wrapper {
            width: 400px;
            padding: 40px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .form-wrapper h1 {
            text-align: center;
            color: #337ab7;
            margin-bottom: 20px;
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
        .form-group input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-actions {
            text-align: center;
        }

        .form-actions input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .form-actions input[type="submit"]:hover {
            background-color: #23527c;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-wrapper">
            <h1>Login</h1>
            <s:form action="loginAction" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" name="email" id="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="form-actions">
                    <s:submit value="Login" />
                </div>
            </s:form>
        </div>
    </div>
</body>
</html>
