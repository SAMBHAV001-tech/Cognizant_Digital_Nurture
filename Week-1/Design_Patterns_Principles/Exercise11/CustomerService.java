public class CustomerService {
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void getCustomer(int id) {
        String result = repo.findCustomerById(id);
        System.out.println("Customer fetched: " + result);
    }
}
