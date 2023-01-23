package StudentPackage;

import java.util.List;
import SubjectPackage.*;

public interface Student {
	
	int getId();
	
	String getName();
	
	String getEmail();

	double getYearlyFee();
	
	void payFees();
	
	boolean areFeesPaid();
	
	int getSemester();
	
	int getYear();
	
	String getDegreeName();
	
	String getDegreeType();
	
	int getDegreeYearNum();
	
	int getDegreeECTS();
	
	double getCourseAverage();
	
	int getECTS();
	
	List<Subject> getSubjects();
	
	void completeSubject(String subjectName, int grade);

	String getInfo();
}