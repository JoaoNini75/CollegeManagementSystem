package StudentPackage;

import java.io.Serializable;
import java.util.List;
import SubjectPackage.*;
import DegreePackage.*;

public class StudentClass implements Student, Serializable {

	private static final String EMAIL = "@ourCollege.com";
	
	private int id, semester, year, ects;
	private String name, email;
	private double courseAverage;
	private boolean feesPaid;
	private Degree degree;
	private List<Subject> subjects;
	
	public StudentClass(int id, String name, Degree degree) {
		this.id = id;
		this.name = name;
		this.degree = degree;
		this.semester = 1;
		this.year = 1;
		this.ects = 0;
		this.feesPaid = false;
		this.courseAverage = -1;
		this.subjects = degree.getSubjects();
		initializeEmail();		
	}
	
	private void nextYear() {
		year++;
	}
	
	private void nextSemester() {
		semester++;
	}
	
	public void completeSubject(String subjectName, int grade) {
		boolean allSemesterSbjsDone = true;
		boolean allYearSbjsDone = true;
		
		for (int i = 0; i < subjects.size(); i++) {
			if (subjects.get(i).getName().equals(subjectName)) {
				ects += subjects.get(i).getECTS();
				subjects.get(i).complete(grade);
			} else if (subjects.get(i).getSemester() == semester && !subjects.get(i).isComplete())
				allSemesterSbjsDone = false;
			else if (subjects.get(i).getYear() == year && !subjects.get(i).isComplete())
				allYearSbjsDone = false;
		}
		
		if (allYearSbjsDone) {
			nextSemester();
			nextYear();
		} else if (allSemesterSbjsDone)
			nextSemester();
		
		updateCourseAverage();
	}

	@Override
	public String getInfo() {
		String info = "Student Info:\n";
		info += "Student ID: " + id + "\n";
		info += "Name: " + name + "\n";
		info += "Email: " + email + "\n";
		info += "Degree: " + degree.getName() + "\n";
		info += "Fees paid: " + feesPaid + "\n";
		info += "ECTS: " + ects + "\n";
		info += "Course Average: " + courseAverage + "\n";
		info += "Current semester: " + semester + "\n";
		info += "Current year: " + year + "\n";
		return info;
	}

	private void updateCourseAverage() {
		double totalGradeSum = 0;
		
		for (int i = 0; i < subjects.size(); i++)
			totalGradeSum += subjects.get(i).getGrade() * subjects.get(i).getECTS();
		
		courseAverage = totalGradeSum / ects;
	}

	private void initializeEmail() {
		email = id + EMAIL;
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
	public void changeDegree(Degree degree) {
		this.degree = degree;
		this.semester = 1;
		this.year = 1;
		this.ects = 0;
		this.courseAverage = -1;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public double getYearlyFee() {
		return degree.getYearlyFee();
	}
	
	@Override
	public void payFees() {
		feesPaid = true;
	}

	@Override
	public boolean areFeesPaid() {
		return feesPaid;
	}

	@Override
	public int getSemester() {
		return semester;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public String getDegreeName() {
		return degree.getName();
	}
	
	@Override
	public String getDegreeType() {
		return degree.getType();
	}
	
	@Override
	public int getDegreeYearNum() {
		return degree.getYearNum();
	}

	@Override
	public int getDegreeECTS() {
		return degree.getECTS();
	}

	@Override
	public double getCourseAverage() {
		return courseAverage;
	}

	@Override
	public int getECTS() {
		return ects;
	}

	@Override
	public List<Subject> getSubjects() {
		return subjects;
	}

}
