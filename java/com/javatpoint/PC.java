package com.javatpoint;

public class PC {
    private int productId;
    private String productName;
    private float productPrice;
    private String catalogId;
    private String catalogName;
    private String catalogDis;

    public PC(int productId, String productName, float productPrice, String catalogId,
              String catalogName, String catalogDis) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogDis = catalogDis;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDis() {
        return catalogDis;
    }

    public void setCatalogDis(String catalogDis) {
        this.catalogDis = catalogDis;
    }
}
