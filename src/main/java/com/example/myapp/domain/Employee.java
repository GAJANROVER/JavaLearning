package com.example.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee implements Serializable {

    private Long employeeId;
    private String first_name;
    private String last_name;
    private Date dob;
    private Double salary;
    private Integer status;

}
