package EmployeePackage;

public interface Employee {
	
	int getId();

	String getType();

	String getName();

	int getWeeklyWorkload();

	void setWeeklyWorkload(int weeklyWorkload);
	
	double getSalary();
	
	void setSalary(double salary);
	
	String getRole();
	
	void setRole(String role);

	String getInfo(String employeeType);
}
