import java.util.List;

public interface Degree {
	
	String getName();
	
	String getType();
	
	int getECTS();
	
	int getYearNum();
	
	double getYearlyFee();
	
	void setYearlyFee(double yearlyFee);
	
	List<Subject> getSubjects();
}
