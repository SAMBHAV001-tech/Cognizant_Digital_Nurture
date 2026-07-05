package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select distinct e from Employee e join fetch e.department left join fetch e.skillList where e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    @Query("select e from Employee e where e.permanent = true")
    List<Employee> getAllPermanentEmployeesLazy();
}
