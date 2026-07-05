package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentNameCustom(@Param("deptName") String deptName);

    @Query(value = "SELECT * FROM employees WHERE salary >= :salary", nativeQuery = true)
    List<Employee> findBySalaryGreaterNative(@Param("salary") Double salary);

    Employee findByNameNamed(@Param("name") String name);

    List<Employee> findBySalaryGreaterNamed(@Param("salary") Double salary);
}
