package com.java8.programs.learning;

public class TestEmployee {
	
	private Integer empid;
	
	private String empname;
	
	private Integer manager_id;
	
	private Double salary;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public TestEmployee(Integer empid, String empname, Integer manager_id, Double salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.manager_id = manager_id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "TestEmployee [empid=" + empid + ", empname=" + empname + ", manager_id=" + manager_id + ", salary="
				+ salary + "]";
	}
	
	

}
