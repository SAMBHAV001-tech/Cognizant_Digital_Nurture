public class EmployeeSystem {
    Employee[] employees;
    int size;

    public EmployeeSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee e) {
        if (size >= employees.length) {
            System.out.println("Array is full. Cannot add " + e.name);
            return;
        }
        employees[size] = e;
        size++;
        System.out.println("Added: " + e.name);
    }

    public Employee searchById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        if (size == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        System.out.println("Deleted: " + employees[index].name);
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
    }
}
