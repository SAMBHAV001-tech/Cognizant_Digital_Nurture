public class Main {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        Logger l3 = Logger.getInstance();

        l1.log("Application started");
        l2.log("User logged in");
        l3.log("Data fetched");

        System.out.println("\n--- Verifying Single Instance ---");
        System.out.println("l1 == l2 : " + (l1 == l2));
        System.out.println("l2 == l3 : " + (l2 == l3));
        System.out.println("l1 hashCode: " + l1.hashCode());
        System.out.println("l2 hashCode: " + l2.hashCode());
        System.out.println("l3 hashCode: " + l3.hashCode());
    }
}
