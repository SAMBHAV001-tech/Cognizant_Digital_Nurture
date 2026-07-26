package com.cognizant.junitassertions;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private Map<Integer, String> studentMap = new HashMap<>();

    public void addStudent(int id, String name) {
        studentMap.put(id, name);
    }

    public String getStudentName(int id) {
        return studentMap.get(id);
    }

    public boolean isStudentActive(double gpa) {
        return gpa >= 2.0;
    }

    public int getStudentCount() {
        return studentMap.size();
    }
}
