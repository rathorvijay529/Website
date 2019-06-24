package com.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Entities.EmployeeEntity;
import com.Entities.ErrorMo;
import com.Entities.SuccessMo;
import com.Service.EmployeeService;

@Controller
public class RestController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity login() {
		employeeService.findBySsn(3);
		return null;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST ,produces="Application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> saveEmployee(
			@RequestBody EmployeeEntity employeeEntity) {
		if (employeeService.saveEmployee(employeeEntity))
			return new ResponseEntity<Object>(new SuccessMo(201,
					"Employee created successfully"), HttpStatus.CREATED);
		else
			return new ResponseEntity(
					new ErrorMo(500, "Internal Server Error"),
					HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
		employeeService.findBySsn(3);
		return null;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Response deleteEmployee(@PathVariable("id") int id) {
		employeeService.findBySsn(3);
		return null;
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ResponseEntity getEmployee() {
		return new ResponseEntity<Object>(employeeService.findBySsn(1),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET,produces="text/plain")
	public ResponseEntity getEmployeed() {
		return new ResponseEntity<Object>(employeeService.findAllEmployee(),
				HttpStatus.OK);
	}
}
