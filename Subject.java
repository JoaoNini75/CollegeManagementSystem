import java.util.List;

public interface Subject {

	String getName();
	
	int getECTS();

	void setECTS(int ects);
	
	List<Professor> getProfessors();

	boolean addProfessor(Professor professor);

	boolean removeProfessor(Professor professor);
	
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
