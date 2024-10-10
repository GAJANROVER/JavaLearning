package com.example.myapp.service;

import com.example.myapp.domain.Employee;

public interface EmployeeService extends CommonService<Employee>{

    Employee find(Long id) throws Exception;

}
