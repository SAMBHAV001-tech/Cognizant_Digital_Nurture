public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addProduct(new Product(1, "Laptop", 10, 75000));
        inv.addProduct(new Product(2, "Mouse", 50, 500));
        inv.addProduct(new Product(3, "Keyboard", 30, 1200));

        System.out.println("\n--- Inventory ---");
        inv.displayAll();

        System.out.println("\n--- Update Product 2 ---");
        inv.updateProduct(2, 45, 550);

        System.out.println("\n--- Delete Product 3 ---");
        inv.deleteProduct(3);

        System.out.println("\n--- Final Inventory ---");
        inv.displayAll();

        System.out.println("\n--- Try adding duplicate ---");
        inv.addProduct(new Product(1, "Laptop Pro", 5, 90000));
    }
}
