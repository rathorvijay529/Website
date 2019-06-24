package com.DAO;

import java.util.List;

import com.MO.Address;
import com.MO.DepartMent;
import com.MO.Employee;


public interface EmployeeDao {
	public Employee getInfo(int id);
	
	public List<Address> getInfoOfAddress(int id);
	
	public boolean saveEmployee(Employee employee);
	
	public DepartMent getInfoOfDepartment(int id);
	
	public List<Employee> getInfoOfAllEmployee();

}
