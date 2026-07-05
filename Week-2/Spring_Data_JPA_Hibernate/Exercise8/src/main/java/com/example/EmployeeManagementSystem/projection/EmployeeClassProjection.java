package com.example.EmployeeManagementSystem.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeClassProjection {

    private Long id;

    private String name;

    private String email;
}
