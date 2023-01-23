package SystemPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import SubjectPackage.*;
import DegreePackage.*;
import EmployeePackage.*;
import StudentPackage.*;

public class ManagementSystem {

	private final int EXPECTED_DEGREE_NUM = 32;
	private final int EXPECTED_SUBJECT_NUM = 256;
	private final int EXPECTED_STUDENT_NUM = 16384;
	private final int EXPECTED_EMPLOYEE_NUM = 1024;
	
	private int employeesIds, studentsIds;
	
	private HashMap<String, Degree> degrees;
	private HashMap<String, Subject> subjects;
	private HashMap<Integer, Student> students;
	private HashMap<Integer, Employee> employees;
	
	public ManagementSystem() {
		this.employeesIds = 0;
		this.studentsIds = 0;
		this.degrees = new HashMap<String, Degree>(EXPECTED_DEGREE_NUM);
		this.subjects = new HashMap<String, Subject>(EXPECTED_SUBJECT_NUM);
		this.students = new HashMap<Integer, Student>(EXPECTED_STUDENT_NUM);
		this.employees = new HashMap<Integer, Employee>(EXPECTED_EMPLOYEE_NUM);
	}

	public void addDegree(String name, String type, int ects, int yearNum, int yearlyFee) {
		Degree degree = new DegreeClass(name, type, ects, yearNum, yearlyFee);
		degrees.put(degree.getName(), degree);
	}

	public Degree removeDegree(String name) {
		Degree degree = degrees.get(name);
		degrees.remove(name);
		return degree;	
	}

	public void addSubjectToDegree(String degreeName, String subjectName) {
		Subject subject = subjects.get(subjectName);
		Degree degree = degrees.get(degreeName);
		degree.addSubject(subject);
	}

	public void removeSubjectFromDegree(String degreeName, String subjectName) {
		Degree degree = degrees.get(degreeName);
		degree.removeSubject(subjectName);
	}

	public boolean degreeExists(String name) {
		return degrees.get(name) != null;
	}

	public boolean degreeHasSubject(String degreeName, String subjectName) {
		Degree degree = degrees.get(degreeName);
		List<Subject> subjects = degree.getSubjects();
		if (subjects == null)
			return false;

		for (int i = 0; i < subjects.size(); i++)
			if (subjects.get(i).getName().equals(subjectName))
				return true;

		return false;
	}

	public List<Subject> listDegreeSubjects(String degreeName) {
		return degrees.get(degreeName).getSubjects();
	}


	public void addSubject(String name, int ects, int semester, int year, int workload) {
		Subject subject = new SubjectClass(name, ects, semester, year, workload);
		subjects.put(subject.getName(), subject);
	}

	public Subject removeSubject(String name) {
		Subject subject = subjects.get(name);
		subjects.remove(name);
		return subject;
	}

	public boolean subjectExists(String name) {
		return subjects.get(name) != null;
	}

	public void addStudent(String name, String degreeName) {
		Student student = new StudentClass(studentsIds++, name, degrees.get(degreeName));
		students.put(student.getId(), student);
	}

	public Student removeStudent(int id) {
		Student student = students.get(id);
		students.remove(id);
		return student;
	}

	public boolean studentExists(int id) {
		return subjects.get(id) != null;
	}

	public void addProfessor(String name, int salary, int weeklyWorkload, String role) {
		Professor professor = new ProfessorClass(employeesIds++, name, salary, weeklyWorkload, role);
		employees.put(professor.getId(), professor);
	}

	public Professor removeProfessor(int id) {
		Professor professor = (Professor) employees.get(id);
		employees.remove(id);
		return professor;
	}

	public void addResearcher(String name, int salary, int weeklyWorkload, String role, String researchGoal, String researchProgress) {
		Researcher researcher = new ResearcherClass(employeesIds++, name, salary, weeklyWorkload, role, researchGoal, researchProgress);
		employees.put(researcher.getId(), researcher);
	}

	public Researcher removeResearcher(int id) {
		Researcher researcher = (Researcher) employees.get(id);
		employees.remove(id);
		return researcher;
	}

	public boolean employeeExists(int id) {
		return employees.get(id) != null;
	}

}
