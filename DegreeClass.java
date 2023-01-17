import java.util.List;

public class DegreeClass implements Degree {
	
	private String name, type; // fazer do type um enumerado (licenciatura, mestrado, doutoramento, outro)
	private int ects, yearNum;
	private double yearlyFee;
	private List<Subject> subjects;
	
	public DegreeClass(String name, String type, int ects, int yearNum, double yearlyFee) {
		this.name = name;
		this.type = type;
		this.ects = ects;
		this.yearNum = yearNum;
		this.yearlyFee = yearlyFee;
		this.subjects = null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public int getECTS() {
		return ects;
	}

	@Override
	public int getYearNum() {
		return yearNum;
	}
	
	@Override
	public double getYearlyFee() {
		return yearlyFee;
	}
	
	@Override
	public List<Subject> getSubjects() {
		return subjects;
	}

	@Override
	public void setYearlyFee(double yearlyFee) {
		this.yearlyFee = yearlyFee;	
	}

	@Override
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	@Override
	public Subject removeSubject(int subjectId) {
		Subject subject = subjects.get(subjectId);
		subjects.remove(subjectId);
		return subject;
	}

}
