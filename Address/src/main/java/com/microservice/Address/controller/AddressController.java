package com.microservice.Address.controller;

import com.microservice.Address.response.AddressResponse;
import com.microservice.Address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;

	@GetMapping("/getAddress/{id}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") int id) {
		return new ResponseEntity<AddressResponse>(service.getAddressById(id), HttpStatus.OK);
	}
}
