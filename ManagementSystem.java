import java.util.HashMap;
import java.util.List;

public class ManagementSystem {

	private final int EXPECTED_DEGREE_NUM = 32;
	private final int EXPECTED_SUBJECT_NUM = 256;
	private final int EXPECTED_STUDENT_NUM = 16384;
	private final int EXPECTED_EMPLOYEE_NUM = 1024;
	
	private int subjectsIds, employeesIds, studentsIds;
	
	private HashMap<String, Degree> degrees;
	private HashMap<Integer, Subject> subjects;
	private HashMap<Integer, Student> students;
	private HashMap<Integer, Employee> employees;
	
	public ManagementSystem() {
		this.subjectsIds = 0;
		this.employeesIds = 0;
		this.studentsIds = 0;
		this.degrees = new HashMap<String, Degree>(EXPECTED_DEGREE_NUM);
		this.subjects = new HashMap<Integer, Subject>(EXPECTED_SUBJECT_NUM);
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

	public void addSubjectToDegree(int subjectId, String degreeName) {
		Subject subject = subjects.get(subjectId);
		Degree degree = degrees.get(degreeName);
		degree.addSubject(subject);
	}

	public boolean degreeExists(String name) {
		return degrees.get(name) != null;
	}

	public void addSubject(int ects, String name, int semester, int year, int workload, List<Professor> professors) {
		Subject subject = new SubjectClass(subjectsIds++, name, ects, semester, year, workload, professors);
		subjects.put(subject.getId(), subject);
	}

	public Subject removeSubject(int id) {
		Subject subject = subjects.get(id);
		subjects.remove(id);
		return subject;
	}

	public boolean subjectExists(int id) {
		return subjects.get(id) != null;
	}

	public void addStudent(String name, Degree degree) {
		Student student = new StudentClass(studentsIds++, name, degree);
		students.put(student.getId(), student);
	}

	public Student removeStudent(int id) {
		Student student = students.get(id);
		students.remove(id);
		return student;
	}

	public void addProfessor(String name, int salary, int weeklyWorkload, String role, List<Subject> subjectsTaught) {
		Professor professor = new ProfessorClass(employeesIds++, name, salary, weeklyWorkload, role, subjectsTaught);
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

}
