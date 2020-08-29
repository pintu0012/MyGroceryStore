package com.example.mygrocerystore.Model;

public class CategoryModel {
    private int id;
    private int image;
    private int color;
    private String title;

    public CategoryModel(int id, int image, int color, String title) {
        this.id = id;
        this.image = image;
        this.color = color;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
