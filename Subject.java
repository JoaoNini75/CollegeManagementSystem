import java.util.List;

public interface Subject {

	int getId();

	String getName();
	
	int getECTS();

	void setECTS(int ects);
	
	List<Professor> getProfessors();

	void setProfessors(List<Professor> professors);
	
	int getTotalWorkload();

	void setTotalWorkload(int workload);
	
	int getSemester();

	void setSemester(int semester);
	
	int getYear();

	void setYear(int year);
	
	boolean isComplete();
	
	void complete(int grade);
	
	int getGrade();
}
