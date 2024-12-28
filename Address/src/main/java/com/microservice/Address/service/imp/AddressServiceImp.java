package com.microservice.Address.service.imp;

import com.microservice.Address.dao.AddressRepo;
import com.microservice.Address.entity.Address;
import com.microservice.Address.response.AddressResponse;
import com.microservice.Address.service.AddressService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressServiceImp implements AddressService {
	@Autowired
	private AddressRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AddressResponse getAddressById(int id) {
		Optional<Address> address = repo.findById(id);
		return mapper.map(address, AddressResponse.class);
	}
}
