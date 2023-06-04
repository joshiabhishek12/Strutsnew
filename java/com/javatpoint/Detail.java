package com.javatpoint;

public class Detail {
    private String id;
    private String productName;
    private float price;
    private String userName;
    private String phoneNum;
    private String address;
    private String adharCardNum;

    public Detail(String id, String productName, float price, String userName, String phoneNum, String address, String adharCardNum) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.address = address;
        this.adharCardNum = adharCardNum;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
