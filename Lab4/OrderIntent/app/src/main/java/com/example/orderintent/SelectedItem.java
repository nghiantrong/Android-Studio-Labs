package com.example.orderintent;

public class SelectedItem {
    private String name;
    private int price;
    private int picture;

    public SelectedItem(String name, int price, int picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPricture(int pricture) {
        this.picture = picture;
    }
}
