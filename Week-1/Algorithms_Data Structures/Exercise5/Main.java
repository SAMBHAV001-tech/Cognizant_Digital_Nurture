public class Main {
    public static void main(String[] args) {
        TaskList list = new TaskList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Write API", "In Progress"));
        list.addTask(new Task(3, "Write Tests", "Pending"));
        list.addTask(new Task(4, "Deploy App", "Pending"));

        System.out.println("\n--- All Tasks ---");
        list.traverse();

        System.out.println("\n--- Search Task ID 2 ---");
        Task t = list.searchTask(2);
        System.out.println(t != null ? "Found: " + t : "Not found");

        System.out.println("\n--- Delete Task ID 1 ---");
        list.deleteTask(1);

        System.out.println("\n--- Delete Task ID 99 ---");
        list.deleteTask(99);

        System.out.println("\n--- Tasks After Deletion ---");
        list.traverse();
    }
}
