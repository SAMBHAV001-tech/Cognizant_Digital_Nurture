package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeClassProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeInterfaceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<EmployeeInterfaceProjection> findInterfaceProjectionsByDepartmentId(Long deptId);

    @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeClassProjection(e.id, e.name, e.email) FROM Employee e WHERE e.department.id = :deptId")
    List<EmployeeClassProjection> findClassProjectionsByDepartmentId(@Param("deptId") Long deptId);
}
