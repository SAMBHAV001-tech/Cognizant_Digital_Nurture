public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) { model.setName(name); }
    public void setStudentGrade(String grade) { model.setGrade(grade); }
    public void setStudentRollNumber(int roll) { model.setRollNumber(roll); }

    public String getStudentName() { return model.getName(); }
    public String getStudentGrade() { return model.getGrade(); }
    public int getStudentRollNumber() { return model.getRollNumber(); }

    public void updateView() {
        view.displayStudent(model.getName(), model.getRollNumber(), model.getGrade());
    }
}
