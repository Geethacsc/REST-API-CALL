package com.microservice.employee.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employee.response.EmployeeResponse;
import com.microservice.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/get-employee/{Employee_id}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("Employee_id") int id) {
		//return new ResponseEntity<EmployeeResponse>(service.getEmployeeDetails(id), HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeDetails(id));
	}
}