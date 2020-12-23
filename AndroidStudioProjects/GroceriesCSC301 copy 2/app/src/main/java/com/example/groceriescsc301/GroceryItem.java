package com.example.groceriescsc301;

/**
 * A grocery item.
 */
public class GroceryItem {
    private String category;
    private String groceryName;
    private Double price;
    private int imageDrawable;

    /**
     * Constructs a new grocery item
     *
     * @param category the food category this grocery item is in
     * @param groceryName the name for the grocery item
     * @param price the price of the grocery item
     * @param imageDrawable the image of the grocery item
     */
    public GroceryItem(String category, String groceryName, Double price, int imageDrawable) {
        this.category = category;
        this.groceryName = groceryName;
        this.price = price;
        this.imageDrawable = imageDrawable;

    }

    /**
     * Returns a string representation of the grocery item
     */
    @Override
    public String toString() {
        return "GroceryItem{" +
                "category='" + category + '\'' +
                ", groceryName='" + groceryName + '\'' +
                ", price=" + price +
                ", imageDrawable=" + imageDrawable +
                '}';
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

}
