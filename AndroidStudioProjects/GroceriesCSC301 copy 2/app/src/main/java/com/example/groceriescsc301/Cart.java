package com.example.groceriescsc301;

import java.util.ArrayList;

/**
 * The cart used in this app.
 */
public final class Cart {
    private static final Cart cart = new Cart(new ArrayList<CartItem>());

    private ArrayList<CartItem> myCartList;

    private Cart(ArrayList<CartItem> myCartList) {
        this.myCartList = myCartList;
    }

    /**
     * Gets the cart item at position.
     */
    public CartItem get(int position) {
        return myCartList.get(position);
    }

    /**
     * Gets the total number of cart items in the cart
     */
    public int size() {
        return myCartList.size();
    }

    /**
     * Adds an item to the cart
     */
    public boolean add(CartItem item) {
        return myCartList.add(item);
    }

    /**
     * Removes the cart item at index from the cart
     */
    public CartItem remove(int index) {
        return myCartList.remove(index);
    }

    /**
     * Remove all cart items
     */
    public void clear() {
        myCartList.clear();
    }

    /**
     * Get the cart instance
     */
    public static Cart getCart() {
        return cart;
    }

}
