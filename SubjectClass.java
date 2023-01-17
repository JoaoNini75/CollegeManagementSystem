import java.util.List;

public class SubjectClass implements Subject {

	private int id, ects, semester, year, grade, workload;
	private String name;
	private boolean isComplete;
	private List<Professor> professors;
	
	public SubjectClass(int id, String name, int ects, int semester, int year, int workload, List<Professor> professors) {
		this.id = id;
		this.name = name;
		this.ects = ects;
		this.workload = workload;
		this.professors = professors;
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
	public void complete(int grade) {
		this.grade = grade;
		isComplete = true;
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
	public List<Professor> getProfessors() {
		return professors;
	}

	@Override
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
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
