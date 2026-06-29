public class Main {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(1, "Alice", 4500.0),
            new Order(2, "Bob", 1200.0),
            new Order(3, "Charlie", 8900.0),
            new Order(4, "Diana", 300.0),
            new Order(5, "Eve", 5600.0)
        };

        Order[] orders2 = {
            new Order(1, "Alice", 4500.0),
            new Order(2, "Bob", 1200.0),
            new Order(3, "Charlie", 8900.0),
            new Order(4, "Diana", 300.0),
            new Order(5, "Eve", 5600.0)
        };

        System.out.println("--- Bubble Sort (by Total Price) ---");
        Sort.bubbleSort(orders1);
        for (Order o : orders1) {
            System.out.println(o);
        }

        System.out.println("\n--- Quick Sort (by Total Price) ---");
        Sort.quickSort(orders2, 0, orders2.length - 1);
        for (Order o : orders2) {
            System.out.println(o);
        }
    }
}
