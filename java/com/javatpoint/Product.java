package com.javatpoint;

public class Product {
    private int id;
    private String name;
    private float price;
    private Catalog catalog;

    // Constructors

    public Product() {
    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, float price, Catalog catalog) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.catalog = catalog;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
