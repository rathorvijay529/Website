package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.EmployeeDao;
import com.Entities.AddressEntity;
import com.Entities.DepartmentEntity;
import com.Entities.EmployeeEntity;
import com.MO.Address;
import com.MO.DepartMent;
import com.MO.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public boolean saveEmployee(EmployeeEntity employee) {
		Employee employee2 = new Employee();
		// employee2.setId(employee.getId());
		employee2.setLname(employee.getLname());
		employee2.setName(employee.getName());
		return dao.saveEmployee(employee2);
	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub

	}

	public EmployeeEntity findBySsn(int id) {

		// doa
		Employee employee = dao.getInfo(id);
		List<Address> list = dao.getInfoOfAddress(id);
		DepartMent departMent = dao.getInfoOfDepartment(id);
		// response
		EmployeeEntity employeeAddress = new EmployeeEntity();
		DepartmentEntity departmentEntity = new DepartmentEntity();
		List<AddressEntity> addressEntities = new ArrayList();
		for (Address address : list) {
			AddressEntity addressEntity = new AddressEntity();
			addressEntity.setAddressId(address.getAddressId());
			addressEntity.sethNo(address.gethNo());
			addressEntity.setZipcode(address.getZipcode());
			addressEntities.add(addressEntity);
		}
		employeeAddress.setId(employee.getId());
		employeeAddress.setLname(employee.getLname());
		employeeAddress.setName(employee.getName());
		employeeAddress.setAddress(addressEntities);
		departmentEntity.setCostCenter(departMent.getCostCenter());
		departmentEntity.setDepartmentName(departMent.getDepartmentName());
		departmentEntity.setDeptId(departMent.getDeptId());
		employeeAddress.setDepartmentEntity(departmentEntity);
		return employeeAddress;
	}

	public void updateEmployee(Employee employee) {
		// Auto-generated method stub

	}

	public List<EmployeeEntity> findAllEmployee() {
		List<Employee> ListEmployee = dao.getInfoOfAllEmployee();
		List<EmployeeEntity> employeeEntities = new ArrayList();
		for (Employee employee : ListEmployee) {
			List<Address> list = dao.getInfoOfAddress(employee.getId());
			DepartMent department = dao.getInfoOfDepartment(employee.getId());
			EmployeeEntity employeeEntity = new EmployeeEntity();
			DepartmentEntity departmentEntity = new DepartmentEntity();
			employeeEntity.setId(employee.getId());
			employeeEntity.setLname(employee.getLname());
			employeeEntity.setName(employee.getName());
			List<AddressEntity> addressEntities = new ArrayList();
			for (Address address : list) {
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setAddressId(address.getAddressId());
				addressEntity.sethNo(address.gethNo());
				addressEntity.setZipcode(address.getZipcode());
				addressEntities.add(addressEntity);
			}
			employeeEntity.setAddress(addressEntities);
			departmentEntity.setCostCenter(department.getCostCenter());
			departmentEntity.setDepartmentName(department.getDepartmentName());
			departmentEntity.setDeptId(department.getDeptId());
			employeeEntity.setDepartmentEntity(departmentEntity);
			employeeEntities.add(employeeEntity);
		}

		return employeeEntities;

	}

}
