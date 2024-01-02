package com.example.shiva.repository;

import com.example.shiva.dao.SearchRequest;
import com.example.shiva.model.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeSearchDao {

    private final EntityManager entityManager;

    public List<Employees> findAllBySimpleQuery(String firstName, String lastName, String email) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employees> employeesCriteriaQuery = criteriaBuilder.createQuery(Employees.class);
        //select*from employee_details
        Root<Employees> root = employeesCriteriaQuery.from(Employees.class);
        //prepare Where clause
        //Where firstName like '%ali%'

        Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
        Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
        Predicate emailPredicate = criteriaBuilder.like(root.get("email"), "%" + email + "%");
        Predicate fistNameorlastNamePredicate = criteriaBuilder.or(
                firstNamePredicate,
                lastNamePredicate);

        //final query select * from employees where firstName like '%ali%'
        //or lastName like '%ali%' and email like'%ali%'
        var andEmailPredicate = criteriaBuilder.and(fistNameorlastNamePredicate, emailPredicate);
        employeesCriteriaQuery.where(andEmailPredicate);

        TypedQuery<Employees> query = entityManager.createQuery(employeesCriteriaQuery);
        return query.getResultList();
    }

    public List<Employees> findAllByCriteria(SearchRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employees> criteriaQuery = criteriaBuilder.createQuery(Employees.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Employees> root = criteriaQuery.from(Employees.class);
        if (request.getFirstName() != null) {
            Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"), "%" + request.getFirstName() + "%");
            predicates.add(firstNamePredicate);
        }
        if (request.getLastName() != null) {
            Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%" + request.getLastName() + "%");
            predicates.add(lastNamePredicate);
        }
        if (request.getEmail() != null) {
            Predicate emailPredicate = criteriaBuilder.like(root.get("email"), "%" + request.getEmail() + "%");
            predicates.add(emailPredicate);
        }
        criteriaQuery.where(
                criteriaBuilder.or(predicates.toArray(new Predicate[0]))
        );
        TypedQuery<Employees> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
