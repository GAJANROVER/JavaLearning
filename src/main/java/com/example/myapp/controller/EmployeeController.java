package com.example.myapp.controller;

import com.example.myapp.domain.Employee;
import com.example.myapp.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/employee")
@Log4j2
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<Employee> find(@RequestParam Long id){
        log.info("employee create stared...");
        try{
            Employee result = employeeService.find(id);
            if (result != null){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        log.info("employee create stared...");
        try{
            Employee result = employeeService.createOrUpdate(employee);
            if (result != null){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }catch (Exception e){
            log.info("Employee create failed. "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
