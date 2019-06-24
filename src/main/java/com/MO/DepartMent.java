package com.MO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="departMent")
public class DepartMent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	private String departmentName;
	private int empId;
	private int costCenter;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(int costCenter) {
		this.costCenter = costCenter;
	}

}
