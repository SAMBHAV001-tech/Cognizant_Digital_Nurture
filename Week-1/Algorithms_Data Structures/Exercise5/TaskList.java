public class TaskList {
    Task head;

    public void addTask(Task t) {
        if (head == null) {
            head = t;
        } else {
            Task curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = t;
        }
        System.out.println("Added: " + t.taskName);
    }

    public Task searchTask(int id) {
        Task curr = head;
        while (curr != null) {
            if (curr.taskId == id) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Task curr = head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.taskId == id) {
            System.out.println("Deleted: " + head.taskName);
            head = head.next;
            return;
        }
        Task curr = head;
        while (curr.next != null) {
            if (curr.next.taskId == id) {
                System.out.println("Deleted: " + curr.next.taskName);
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }
}
