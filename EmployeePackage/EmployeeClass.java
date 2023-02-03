package EmployeePackage;

import java.io.Serializable;

public abstract class EmployeeClass implements Employee, Serializable {

	private final int id;
	private int weeklyWorkload;
	private final String name;
	private String role;
	private double salary; 		// monthly
	
	public EmployeeClass(int id, String name, int salary, int weeklyWorkload, String role) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.weeklyWorkload = weeklyWorkload;
		this.role = role;
	}

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getWeeklyWorkload() {
		return weeklyWorkload;
	}

	@Override
	public void setWeeklyWorkload(int weeklyWorkload) {
		this.weeklyWorkload = weeklyWorkload;
	}

	@Override
	public String getRole() {
		return role;
	}

	@Override
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String getInfo(String employeeType) {
		String info = employeeType + " Info:\n";
		info += "Name: " + name + "\n";
		info += "Salary: " + salary + "\n";
		info += "Weekly workload: " + weeklyWorkload + "\n";
		info += "Role: " + role + "\n";
		return info;
	}
}
