package com.example.rvarg.actionbar.ListFragments;

/**
 * Created by rvarg on 24/08/2017.
 */

public class Producto {
   private int id;
    private String description;
    private double price;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Producto(int id, String description, double price, String image) {

        this.id = id;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}
