
public class EmployeeClass implements Employee {

	private int id;
	private String name, role;
	private double salary; 		// monthly
	
	public EmployeeClass(int id, String name, int salary, String role) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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
}
