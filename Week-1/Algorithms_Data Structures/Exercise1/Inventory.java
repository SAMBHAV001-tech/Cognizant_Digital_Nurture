import java.util.HashMap;

public class Inventory {
    HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        if (products.containsKey(p.productId)) {
            System.out.println("Product with ID " + p.productId + " already exists.");
        } else {
            products.put(p.productId, p);
            System.out.println("Added: " + p.productName);
        }
    }

    public void updateProduct(int id, int newQty, double newPrice) {
        if (products.containsKey(id)) {
            products.get(id).quantity = newQty;
            products.get(id).price = newPrice;
            System.out.println("Updated product ID: " + id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        if (products.containsKey(id)) {
            System.out.println("Deleted: " + products.get(id).productName);
            products.remove(id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
