package com.dao.model;

public class Menu {

    private int menu_id;
    private int restaurantid;
    private String itemName;
    private String description;
    private double price;
    private float rating;
    private String isAvailable;
    private String imagePath;

    public Menu() {}

    // Constructor without menu_id (for insert)
    public Menu(int restaurantid, String itemName, String description, double price, float rating, String isAvailable, String imagePath) {
        this.restaurantid = restaurantid;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.isAvailable = isAvailable;
        this.imagePath = imagePath;
    }

    // Constructor with menu_id (for update/retrieve)
    public Menu(int menu_id, int restaurantid, String itemName, String description, double price, float rating, String isAvailable, String imagePath) {
        this(restaurantid, itemName, description, price, rating, isAvailable, imagePath);
        this.menu_id = menu_id;
    }

    // Getters and Setters
    public int getMenu_id() { return menu_id; }
    public void setMenu_id(int menu_id) { this.menu_id = menu_id; }
    public int getRestaurantid() { return restaurantid; }
    public void setRestaurantid(int restaurantid) { this.restaurantid = restaurantid; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public String getIsAvailable() { return isAvailable; }
    public void setIsAvailable(String isAvailable) { this.isAvailable = isAvailable; }
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    @Override
    public String toString() {
        return "Menu [menu_id=" + menu_id + ", restaurantid=" + restaurantid + ", itemName=" + itemName
                + ", description=" + description + ", price=" + price + ", rating=" + rating + ", isAvailable="
                + isAvailable + ", imagePath=" + imagePath + "]";
    }
}
