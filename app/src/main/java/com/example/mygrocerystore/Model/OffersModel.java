package com.example.mygrocerystore.Model;

public class OffersModel {
    private int id;
    private int image;
    private String title;
    private int color;

    public OffersModel(int id, int image, String title, int color) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
