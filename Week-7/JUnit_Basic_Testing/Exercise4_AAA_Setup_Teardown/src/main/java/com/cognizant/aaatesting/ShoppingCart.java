package com.cognizant.aaatesting;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();

    public void addItem(String itemName, double price) {
        items.put(itemName, price);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalPrice() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public void clear() {
        items.clear();
    }
}
