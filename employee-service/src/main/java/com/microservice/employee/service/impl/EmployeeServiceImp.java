package com.microservice.employee.service.impl;

import java.util.Optional;

import com.microservice.employee.client.RestApiCallUsingOpenFeign;
import com.microservice.employee.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import com.microservice.employee.dao.EmployeeRepo;
import com.microservice.employee.entity.Employee;
import com.microservice.employee.response.EmployeeResponse;
import com.microservice.employee.service.EmployeeService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
REST API CALL USING:
RESTTemplate
Web Client/Web Flux
Feign Client- Netflix
 */
@Component
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private ModelMapper mapper;

	//@Autowired
	//private RestTemplate restApiCall;

	@Autowired
	private WebClient webClient;

	@Value("${microservice.address.base.url}")
	private String addressBaseUrl;

	@Autowired
	private RestApiCallUsingOpenFeign addressClient;

//	public EmployeeServiceImp(@Value("${microservice.address.base.url}") String addressBaseUrl,RestTemplateBuilder builder) {
//		this.restApiCall = builder																									.rootUri(addressBaseUrl).build();
//	}


	public EmployeeResponse getEmployeeDetails(int id) {
		Optional<Employee> employee = repo.findById(id);
		EmployeeResponse employeeResponse= mapper.map(employee, EmployeeResponse.class);

		/*REST API CALL USING RESTTemplate
		 * RESTTemplate is a blocking call in Nature
		 */
		//System.out.println("url: "+baseUrl);
		//AddressResponse address=restApiCall.getForObject(baseUrl+"/getAddress/{id}", AddressResponse.class, id);

		//AddressResponse address=restApiCall.getForObject("/getAddress/{id}", AddressResponse.class, id);

		/**
		 * REST API CALL(calling external service) USING WEB CLIENT
		 * Web Client is non blocking in nature
		 * We can make Web Client blocking by calling block() method
		**/
//		Mono<AddressResponse> monoAddress=webClient.get().uri("/getAddress/"+id).retrieve().bodyToMono(AddressResponse.class);
//
//		AddressResponse address= monoAddress.block();//makes the web client a blocking call

		/**
		 * REST API Call Using OPEN FEIGN -Netflix product
		 */

		AddressResponse address=addressClient.getAddressByEmployeeId(id).getBody();

		System.out.println("after rest api call");
		employeeResponse.setAddress(address);
		return employeeResponse;
	}
}
