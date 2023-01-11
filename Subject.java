import java.util.List;

public interface Subject {

	int getId();
	
	int getECTS();
	
	List<Professor> getProfessors();
	
	int getTotalWorkload();
	
	int getSemester();
	
	int getYear();
	
	boolean isComplete();
	
	void complete(int grade);
	
	int getGrade();
}
