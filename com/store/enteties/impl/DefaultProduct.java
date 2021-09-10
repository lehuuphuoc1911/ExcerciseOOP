package com.store.enteties.impl;

import com.store.enteties.Product;

public class DefaultProduct implements Product {
    private int id;
    private String productName;
    private double price;
    private String categoryName;

    public DefaultProduct(){
    }
    public DefaultProduct(int id,String productName, String categoryName, double price){
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product id=" + id + ", product name=" + productName
                + ", category name=" + categoryName + ", price=" + price;
    }
}
