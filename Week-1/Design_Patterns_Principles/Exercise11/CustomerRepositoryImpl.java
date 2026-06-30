public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        if (id == 1) return "Alice (ID: 1)";
        if (id == 2) return "Bob (ID: 2)";
        if (id == 3) return "Charlie (ID: 3)";
        return "Customer not found for ID: " + id;
    }
}
