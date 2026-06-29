import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Watch", "Accessories"),
            new Product(4, "Headphones", "Electronics"),
            new Product(5, "Backpack", "Bags")
        };

        System.out.println("--- Linear Search ---");
        Product result1 = Search.linearSearch(products, "Watch");
        System.out.println(result1 != null ? "Found: " + result1 : "Not found");

        Product result2 = Search.linearSearch(products, "Tablet");
        System.out.println(result2 != null ? "Found: " + result2 : "Not found");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n--- Products sorted by name ---");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\n--- Binary Search ---");
        Product result3 = Search.binarySearch(products, "Laptop");
        System.out.println(result3 != null ? "Found: " + result3 : "Not found");

        Product result4 = Search.binarySearch(products, "Tablet");
        System.out.println(result4 != null ? "Found: " + result4 : "Not found");
    }
}
