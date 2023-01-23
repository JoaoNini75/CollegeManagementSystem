package SubjectPackage;

import java.util.ArrayList;
import java.util.List;
import EmployeePackage.*;

public class SubjectClass implements Subject {

	private int ects, semester, year, grade, workload;
	private String name;
	private boolean isComplete;
	private List<Professor> professors;
	
	public SubjectClass(String name, int ects, int semester, int year, int workload) {
		this.name = name;
		this.ects = ects;
		this.workload = workload;
		this.professors = new ArrayList<>(10);
		this.isComplete = false;
		this.grade = -1;
	}

	@Override
	public int getECTS() {
		return ects;
	}

	@Override
	public void setECTS(int ects) {
		this.ects = ects;
	}

	@Override
	public boolean isComplete() {
		return isComplete;
	}

	@Override
	public int getGrade() {
		return grade;
	}

	@Override
	public String getInfo() {
		String info = "Subject Info:\n";
		info += "Name: " + name + "\n";
		info += "ECTS: " + ects + "\n";
		info += "Semester: " + semester + "\n";
		info += "Year: " + year + "\n";
		info += "Workload: " + workload + "\n";
		return info;
	}

	@Override
	public void complete(int grade) {
		this.grade = grade;
		isComplete = true;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Professor> getProfessors() {
		return professors;
	}

	@Override
	public boolean addProfessor(Professor professor) {
		if (professors.contains(professor))
			return false;
		professors.add(professor);
		return true;
	}

	@Override
	public boolean removeProfessor(Professor professor) {
		if (!professors.contains(professor))
			return false;
		professors.remove(professor);
		return true;
	}

	@Override
	public int getTotalWorkload() {
		return workload;
	}

	@Override
	public void setTotalWorkload(int workload) {
		this.workload = workload;
	}

	@Override
	public int getSemester() {
		return semester;
	}

	@Override
	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public void setYear(int year) {
		this.year = year;
	}
}
