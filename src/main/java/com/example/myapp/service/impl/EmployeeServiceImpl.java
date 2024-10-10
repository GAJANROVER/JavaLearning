package com.example.myapp.service.impl;

import com.example.myapp.domain.Employee;
import com.example.myapp.entity.EmployeeEntity;
import com.example.myapp.repo.EmployeeRepository;
import com.example.myapp.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Employee createOrUpdate(Employee employee) throws Exception {

        EmployeeEntity employeeEntity = null;
        if (employee.getEmployeeId() != null){
            Optional<EmployeeEntity> existEmployeeEntity = employeeRepository.findById(employee.getEmployeeId());
            if (existEmployeeEntity.isPresent()){
                employeeEntity = existEmployeeEntity.get();
                modelMapper.getConfiguration().setSkipNullEnabled(true);
                modelMapper.map(employee,employeeEntity);
                EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
                return modelMapper.map(savedEmployee,Employee.class);
            }else{
                employeeEntity = new EmployeeEntity();
            }
        }else{
            employeeEntity = new EmployeeEntity();
        }
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(employee,employeeEntity);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, Employee.class);
    }


    @Override
    public Employee find(Long id) throws Exception{
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return modelMapper.map(employee.get(), Employee.class);
        }else{
            return null;
        }
    }
}
