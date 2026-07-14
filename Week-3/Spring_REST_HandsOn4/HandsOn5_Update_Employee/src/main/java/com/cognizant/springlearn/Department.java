package com.cognizant.springlearn;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Department {

    @Min(value = 1, message = "Department ID must be at least 1")
    private int id;

    @NotNull(message = "Department name cannot be null")
    @Size(min = 1, message = "Department name cannot be empty")
    private String name;

    public Department() {}

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
