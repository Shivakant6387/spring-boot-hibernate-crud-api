package com.example.shiva.service;

import com.example.shiva.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public Employee findById(long id);
    public List<Employee>findAll();
    public Employee update(Employee employee,long id);
    public void delete(long id);
}
