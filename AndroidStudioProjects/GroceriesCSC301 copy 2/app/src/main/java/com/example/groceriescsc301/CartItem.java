package com.example.groceriescsc301;

/**
 * A cart item.
 */
public class CartItem {
    private String groceryName;
    private Double price;
    private int quantity;
    private int imageDrawable;

    /**
     * Constructs a new cart item
     *
     * @param groceryName the name for the cart item
     * @param price the price of the cart item
     * @param quantity the quantity of the cart item
     * @param imageDrawable the image of the cart item
     */
    public CartItem(String groceryName, Double price, int quantity, int imageDrawable) {
        this.groceryName = groceryName;
        this.price = price;
        this.quantity = quantity;
        this.imageDrawable = imageDrawable;
    }

    public String getGroceryName() {
        return groceryName;
    }

    public void setGroceryName(String groceryName) {
        this.groceryName = groceryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}
