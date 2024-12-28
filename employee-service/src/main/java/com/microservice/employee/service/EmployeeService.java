package com.microservice.employee.service;

import org.springframework.stereotype.Service;

import com.microservice.employee.response.EmployeeResponse;

@Service
public interface EmployeeService {

	EmployeeResponse getEmployeeDetails(int id);

}
