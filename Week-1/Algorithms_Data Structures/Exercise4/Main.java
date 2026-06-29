public class Main {
    public static void main(String[] args) {
        EmployeeSystem sys = new EmployeeSystem(5);

        sys.addEmployee(new Employee(1, "Alice", "Manager", 85000));
        sys.addEmployee(new Employee(2, "Bob", "Developer", 65000));
        sys.addEmployee(new Employee(3, "Charlie", "Designer", 55000));
        sys.addEmployee(new Employee(4, "Diana", "Tester", 50000));

        System.out.println("\n--- All Employees ---");
        sys.traverse();

        System.out.println("\n--- Search Employee ID 3 ---");
        Employee e = sys.searchById(3);
        System.out.println(e != null ? "Found: " + e : "Not found");

        System.out.println("\n--- Search Employee ID 10 ---");
        Employee e2 = sys.searchById(10);
        System.out.println(e2 != null ? "Found: " + e2 : "Not found");

        System.out.println("\n--- Delete Employee ID 2 ---");
        sys.deleteEmployee(2);

        System.out.println("\n--- Employees After Deletion ---");
        sys.traverse();
    }
}
