package com.example.myapp.controller;

import com.example.myapp.entity.Employee;
import com.example.myapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.createOrUpdate(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        employeeService.deleteEmployee(id);
    }

}
