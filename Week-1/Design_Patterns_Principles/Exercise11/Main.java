public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        System.out.println("--- Fetching Customers via Injected Repository ---");
        service.getCustomer(1);
        service.getCustomer(2);
        service.getCustomer(3);
        service.getCustomer(99);
    }
}
