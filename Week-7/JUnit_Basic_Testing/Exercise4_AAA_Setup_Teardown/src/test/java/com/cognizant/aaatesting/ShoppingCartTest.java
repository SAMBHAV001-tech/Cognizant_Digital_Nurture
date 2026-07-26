package com.cognizant.aaatesting;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        cart.addItem("Laptop", 50000.0);
    }

    @After
    public void tearDown() {
        cart.clear();
        cart = null;
    }

    @Test
    public void testAddItem() {
        String item = "Mouse";
        double price = 1500.0;

        cart.addItem(item, price);

        assertEquals(2, cart.getItemCount());
        assertEquals(51500.0, cart.getTotalPrice(), 0.001);
    }

    @Test
    public void testRemoveItem() {
        String itemToRemove = "Laptop";

        cart.removeItem(itemToRemove);

        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotalPrice(), 0.001);
    }

    @Test
    public void testCalculateTotal() {
        cart.addItem("Headphones", 3500.0);

        double total = cart.getTotalPrice();

        assertEquals(53500.0, total, 0.001);
    }
}
