import java.util.List;

public class SubjectClass implements Subject {

	private int id, ects, semester, year, grade, workload;
	private boolean isComplete;
	private List<Professor> professors;
	
	public SubjectClass(int id, int ects, int semester, int year, int workload, List<Professor> professors) {
		this.id = id;
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
	public List<Professor> getProfessors() {
		return professors;
	}

	@Override
	public int getTotalWorkload() {
		return workload;
	}

	@Override
	public int getSemester() {
		return semester;
	}

	@Override
	public int getYear() {
		return year;
	}
}
