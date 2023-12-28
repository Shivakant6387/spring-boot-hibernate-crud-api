package com.example.shiva.controller;

import com.example.shiva.model.Employee;
import com.example.shiva.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(employeeService.findById(employeeId), HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
            , @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.update(employee, id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

        employeeService.delete(id);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
