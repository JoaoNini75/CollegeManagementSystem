import java.util.List;

public interface Degree {
	
	String getName();
	
	String getType();
	
	int getECTS();
	
	int getYearNum();
	
	double getYearlyFee();
	
	void setYearlyFee(double yearlyFee);

	void addSubject(Subject subject);

	Subject removeSubject(int subjectId);
	
	List<Subject> getSubjects();
}
