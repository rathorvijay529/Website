package com.DAO;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.MO.Address;
import com.MO.DepartMent;
import com.MO.Employee;

@Repository("dao")
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	public Employee getInfo(int id) {
		List<Employee> l = getSession().createCriteria(Employee.class)
				.add(Restrictions.eq("id", id)).list();
		return l.get(0);

	}
	
	public List<Employee> getInfoOfAllEmployee() {
		List<Employee> l = getSession().createCriteria(Employee.class).list();
		return l;

	}

	public DepartMent getInfoOfDepartment(int id) {
		List<DepartMent> l = getSession().createCriteria(DepartMent.class)
				.add(Restrictions.eq("empId", id)).list();
		return l.get(0);

	}

	public List<Address> getInfoOfAddress(int id) {
		List<Address> l = getSession().createCriteria(Address.class)
				.add(Restrictions.eq("empId", id)).list();
		return l;

	}

	public boolean saveEmployee(Employee employee) {
		save(employee);
		return true;
	}

}
