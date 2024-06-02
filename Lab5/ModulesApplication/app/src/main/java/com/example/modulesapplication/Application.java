package com.example.modulesapplication;

public class Application {
    private int image;
    private String title;
    private String description;
    private int icon;

    public Application(int image, String title, String description, int icon) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.icon = icon;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
