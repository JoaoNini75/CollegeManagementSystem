import java.util.HashMap;
import java.util.List;

public class ManagementSystem {

	private final int EXPECTED_DEGREE_NUM = 32;
	private final int EXPECTED_SUBJECT_NUM = 256;
	
	private int subjectsIds, employeesIds, studentsIds;
	
	private HashMap<String, Degree> degrees;
	private HashMap<Integer, Subject> subjects;
	
	public ManagementSystem() {
		this.subjectsIds = 0;
		this.employeesIds = 0;
		this.studentsIds = 0;
		this.degrees = new HashMap<String, Degree>(EXPECTED_DEGREE_NUM);
		this.subjects = new HashMap<Integer, Subject>(EXPECTED_SUBJECT_NUM);
	}
	
	void addDegree(String name, String type, int ects, int yearNum, int yearlyFee, List<Subject> subjects) {
		Degree degree = new DegreeClass(name, type, ects, yearNum, yearlyFee, subjects);
		degrees.put(degree.getName(), degree);
	}
	
	Degree removeDegree(String name) {
		Degree degree = degrees.get(name);
		degrees.remove(name);
		return degree;	
	}
	
	void addSubject(int ects, int semester, int year, int workload, List<Professor> professors) {
		Subject subject = new SubjectClass(subjectsIds, ects, semester, year, workload, professors);	
		subjects.put(subject.getId(), subject);
		subjectsIds++;
	}
	
	Subject removeSubject(int id) {
		Subject subject = subjects.get(id);
		subjects.remove(id);
		return subject;
	}
	
	void addEmployee() {
		
	}
	
	Employee removeEmployee() {
		return null; // TODO
	}
	
	void addStudent() {
		
	}
	
	Student removeStudent() {
		return null; // TODO	
	}
}
