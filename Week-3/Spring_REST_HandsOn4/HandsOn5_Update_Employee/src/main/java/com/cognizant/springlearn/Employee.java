package com.cognizant.springlearn;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class Employee {

    @NotNull(message = "Employee ID cannot be null")
    @Size(min = 1, message = "Employee ID cannot be empty")
    private String id;

    @NotNull(message = "Employee name cannot be null")
    @Size(min = 1, max = 30, message = "Employee name must be between 1 and 30 characters")
    private String name;

    @Min(value = 0, message = "Salary must be non-negative")
    private double salary;

    @NotNull(message = "Department cannot be null")
    @Valid
    private Department department;

    @Valid
    private List<Skill> skills;

    public Employee() {}

    public Employee(String id, String name, double salary, Department department, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + ", skills=" + skills + "]";
    }
}
