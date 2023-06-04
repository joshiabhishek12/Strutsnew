package com.javatpoint;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
    private String email;
    private String password;

    // Getters and Setters for email and password

    public void validate() {
        if (email == null || email.trim().isEmpty()) {
            addFieldError("email", "Email cannot be empty");
        }
        
        if (password == null || password.trim().isEmpty()) {
            addFieldError("password", "Password cannot be empty");
        }
    }

    public String execute() {
        // Add your login logic here
        if (isValidLogin()) {
            return SUCCESS; // Redirect to index.jsp
        } else {
            addActionError("Invalid email or password");
            return INPUT; // Forward back to login.jsp
        }
    }

    private boolean isValidLogin() {
        // Add your login validation logic here
        // Return true if the login is valid, false otherwise
        // You can check against a database, validate credentials, etc.
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
