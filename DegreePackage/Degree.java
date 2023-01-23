package DegreePackage;

import java.util.List;
import SubjectPackage.*;

public interface Degree {
	
	String getName();
	
	String getType();
	
	int getECTS();
	
	int getYearNum();
	
	double getYearlyFee();
	
	void setYearlyFee(double yearlyFee);

	void addSubject(Subject subject);

	Subject removeSubject(String subjectName);
	
	List<Subject> getSubjects();

	String getInfo();
}
