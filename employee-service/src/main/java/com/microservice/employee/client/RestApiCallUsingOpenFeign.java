package com.microservice.employee.client;

import com.microservice.employee.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//REST API Call using Feign Client
@FeignClient(name="address-service" ,url = "http://localhost:8081/address-service/api")
public interface RestApiCallUsingOpenFeign {

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") int id);
}
