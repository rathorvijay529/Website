package com.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.Entities.EmployeeEntity;
import com.MO.Employee;
@Transactional
public interface EmployeeService {
	boolean saveEmployee(EmployeeEntity employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);

	EmployeeEntity findBySsn(int ssn);

	void updateEmployee(Employee employee);
	
	public List<EmployeeEntity> findAllEmployee();
}
