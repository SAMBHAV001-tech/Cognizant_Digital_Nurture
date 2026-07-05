package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Employee> searchEmployees(String name, Double minSalary, Double maxSalary, Boolean permanent) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.trim().isEmpty()) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }
        if (minSalary != null) {
            predicates.add(cb.ge(root.get("salary"), minSalary));
        }
        if (maxSalary != null) {
            predicates.add(cb.le(root.get("salary"), maxSalary));
        }
        if (permanent != null) {
            predicates.add(cb.equal(root.get("permanent"), permanent));
        }

        query.select(root).where(predicates.toArray(new Predicate[0]));
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
