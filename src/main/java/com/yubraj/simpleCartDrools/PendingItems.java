package com.yubraj.simpleCartDrools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ypokhrel on 7/26/2017.
 */
public class PendingItems {
    private Customer customer;
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public PendingItems(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }
}
