public class Main {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo.jpg");

        System.out.println("--- First call (loads from disk) ---");
        img.display();

        System.out.println("\n--- Second call (uses cached image) ---");
        img.display();

        System.out.println("\n--- Third call (still uses cached) ---");
        img.display();
    }
}
