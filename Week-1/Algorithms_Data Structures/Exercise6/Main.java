import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Clean Code", "Robert Martin"),
            new Book(2, "The Pragmatic Programmer", "Andrew Hunt"),
            new Book(3, "Introduction to Algorithms", "Cormen"),
            new Book(4, "Design Patterns", "Gang of Four"),
            new Book(5, "Effective Java", "Joshua Bloch")
        };

        System.out.println("--- Linear Search ---");
        Book b1 = Library.linearSearch(books, "Effective Java");
        System.out.println(b1 != null ? "Found: " + b1 : "Not found");

        Book b2 = Library.linearSearch(books, "Harry Potter");
        System.out.println(b2 != null ? "Found: " + b2 : "Not found");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n--- Books sorted by title ---");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n--- Binary Search ---");
        Book b3 = Library.binarySearch(books, "Design Patterns");
        System.out.println(b3 != null ? "Found: " + b3 : "Not found");

        Book b4 = Library.binarySearch(books, "Harry Potter");
        System.out.println(b4 != null ? "Found: " + b4 : "Not found");
    }
}
