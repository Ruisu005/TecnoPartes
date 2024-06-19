package com.example.tecnopartes;

public class Product {

    private String name;
    private String brand;
    private String category;
    private double price;
    private int imageResourceId; // ID del recurso de imagen

    public Product(String name, String brand, String category, double price, int imageResourceId) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
