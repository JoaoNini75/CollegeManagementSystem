package DegreePackage;

import java.util.ArrayList;
import java.util.List;
import SubjectPackage.*;

public class DegreeClass implements Degree {
	
	private String name, type; // fazer do type um enumerado (licenciatura, mestrado integrado, mestrado, doutoramento, pos-graduacao, outro)
	private int ects, yearNum;
	private double yearlyFee;
	private List<Subject> subjects;
	
	public DegreeClass(String name, String type, int ects, int yearNum, double yearlyFee) {
		this.name = name;
		this.type = type;
		this.ects = ects;
		this.yearNum = yearNum;
		this.yearlyFee = yearlyFee;
		this.subjects = new ArrayList<>(10);
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
	public String getInfo() {
		String info = "Degree Info:\n";
		info += "Name: " + name + "\n";
		info += "Type: " + type + "\n";
		info += "ECTS: " + ects + "\n";
		info += "Number of years: " + yearNum + "\n";
		info += "Yearly fee: " + yearlyFee + "\n";
		return info;
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
	public Subject removeSubject(String subjectName) {
		Subject subject = null;
		for (int i = 0; i < subjects.size(); i++)
			if (subjects.get(i).getName().equals(subjectName)) {
				subject = subjects.remove(i);
				break;
			}
		return subject;
	}

}
