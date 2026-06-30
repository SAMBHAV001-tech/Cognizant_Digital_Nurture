public class Main {
    public static void main(String[] args) {
        Student model = new Student("Alice", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("--- Initial Data ---");
        controller.updateView();

        System.out.println("\n--- Updating Name and Grade ---");
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");
        controller.updateView();

        System.out.println("\n--- Updating Roll Number ---");
        controller.setStudentRollNumber(202);
        controller.updateView();
    }
}
