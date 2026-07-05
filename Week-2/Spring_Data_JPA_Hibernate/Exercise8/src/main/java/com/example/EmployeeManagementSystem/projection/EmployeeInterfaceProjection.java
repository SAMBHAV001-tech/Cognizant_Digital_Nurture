package com.example.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeInterfaceProjection {

    Long getId();

    String getName();

    String getEmail();

    @Value("#{target.name + ' (' + target.department.name + ')'}")
    String getFullNameWithDept();
}
