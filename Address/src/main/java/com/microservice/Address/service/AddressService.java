package com.microservice.Address.service;

import com.microservice.Address.dao.AddressRepo;
import com.microservice.Address.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    AddressResponse getAddressById(int id);
}

