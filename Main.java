import java.util.Scanner;
import SubjectPackage.*;
import DegreePackage.*;
import EmployeePackage.*;
import StudentPackage.*;
import SystemPackage.*;

public class Main {

	// Comandos do utilizador
	private static final String HELP = "HELP";
	private static final String ADD_DEGREE = "ADD_DEGREE";
	private static final String ADD_SUBJECT = "ADD_SUBJECT";
	private static final String ADD_STUDENT = "ADD_STUDENT";
	private static final String ADD_PROFESSOR = "ADD_PROFESSOR";
	private static final String ADD_RESEARCHER = "ADD_RESEARCHER";

	private static final String REMOVE_DEGREE = "REMOVE_DEGREE";
	private static final String REMOVE_SUBJECT = "REMOVE_SUBJECT";
	private static final String REMOVE_STUDENT = "REMOVE_STUDENT";
	private static final String REMOVE_PROFESSOR = "REMOVE_PROFESSOR";
	private static final String REMOVE_RESEARCHER = "REMOVE_RESEARCHER";

	private static final String ADD_SUBJECT_TO_DEGREE = "ADD_SUBJECT_DEGREE";



	private static final String EXIT = "EXIT";


	// Feedback dado pelo programa
	private static final String WELCOME = "Welcome to the college management system :)\nType help to get the list of the available commands.";
	private static final String PRINT_HELP = "TODO";
	private static final String INVALID_ARGUMENTS = "Invalid arguments. For more information, type help.";
	private static final String EXITING = "Exiting...";


	private static final String DEGREE_EXISTS = "Degree already exists.";
	private static final String DEGREE_ADDED = "Degree added.";
	private static final String DEGREE_NOT_EXIST = "Degree does not exist.";
	private static final String DEGREE_REMOVED = "Degree removed.";

	private static final String SUBJECT_ADDED_TO_DEGREE = "Subject added to degree.";
	private static final String SUBJECT_NOT_EXIST = "Subject does not exist.";
	private static final String SUBJECT_ADDED = "Subject added.";
	private static final String SUBJECT_ALREADY_ADDED = "Subject was already added.";
	private static final String SUBJECT_REMOVED = "Subject removed.";

	private static final String STUDENT_ADDED = "Student added.";
	private static final String STUDENT_NOT_EXIST = "Student does not exist.";
	private static final String STUDENT_REMOVED = "Student removed.";

	private static final String PROFESSOR_ADDED = "Professor added.";
	private static final String PROFESSOR_NOT_EXIST = "Professor does not exist.";
	private static final String PROFESSOR_REMOVED = "Professor removed.";

	private static final String RESEARCHER_ADDED = "Researcher added.";
	private static final String RESEARCHER_NOT_EXIST = "Researcher does not exist.";
	private static final String RESEARCHER_REMOVED = "Researcher removed.";



	public static void main(String[] args) {
		commands();
	}

	// TODO tentar tornar o programa mais visual (html, gui, etc)
	private static void commands() {
		ManagementSystem ms = new ManagementSystem();
		Scanner in = new Scanner(System.in);
		System.out.println(WELCOME);
		String userIn = in.next().toUpperCase();
		while (!userIn.equals(EXIT)) {
			switch (userIn) {
				case HELP -> System.out.println(PRINT_HELP);
				case ADD_DEGREE -> addDegree(in, ms);
				case ADD_SUBJECT -> addSubject(in, ms);
				case ADD_STUDENT -> addStudent(in, ms);
				case ADD_PROFESSOR -> addProfessor(in, ms);
				case ADD_RESEARCHER -> addResearcher(in, ms);
				case REMOVE_DEGREE -> removeDegree(in, ms);
				case REMOVE_SUBJECT -> removeSubject(in, ms);
				case REMOVE_STUDENT -> removeStudent(in, ms);
				case REMOVE_PROFESSOR -> removeProfessor(in, ms);
				case REMOVE_RESEARCHER -> removeResearcher(in, ms);
				case ADD_SUBJECT_TO_DEGREE -> addSubjectToDegree(in, ms);
				default -> {
				}
			}
			userIn = in.next().toUpperCase();
		}
		System.out.println(EXITING);
		in.close();
	}

	private static void addDegree(Scanner in, ManagementSystem ms) {
		String name = in.next();
		String type = in.next();
		int ects = in.nextInt();
		int yearNum = in.nextInt();
		int yearlyFee = in.nextInt();
		in.nextLine();

		if (name.equals("") || type.equals("") || ects <= 0 ||  yearNum <= 0 || yearlyFee <= 0)
			System.out.println(INVALID_ARGUMENTS);
		else if (ms.degreeExists(name))
			System.out.println(DEGREE_EXISTS);
		else {
			ms.addDegree(name, type, ects, yearNum, yearlyFee);
			System.out.println(DEGREE_ADDED);
		}
	}

	private static void addSubject(Scanner in, ManagementSystem ms) {
		String name = in.next();
		int ects = in.nextInt();
		int semester = in.nextInt();
		int year = in.nextInt();
		int workload = in.nextInt();
		in.nextLine();

		if (name.equals("") || ects <= 0 || semester <= 0 || year <= 0 || workload <= 0)
			System.out.println(INVALID_ARGUMENTS);
		else if (ms.subjectExists(name))
			System.out.println(SUBJECT_ALREADY_ADDED);
		else {
			ms.addSubject(name, ects, semester, year, workload);
			System.out.println(SUBJECT_ADDED);
		}
	}

	private static void addStudent(Scanner in, ManagementSystem ms) {
		String name = in.next();
		String degreeName = in.nextLine().trim();

		if (name.equals("") || degreeName.equals(""))
			System.out.println(INVALID_ARGUMENTS);
		else {
			ms.addStudent(name, degreeName);
			System.out.println(STUDENT_ADDED);
		}
	}

	private static void addProfessor(Scanner in, ManagementSystem ms) {
		String name = in.next();
		int salary = in.nextInt();
		int weeklyWorkload = in.nextInt();
		String role = in.nextLine().trim();

		if (name.equals("") || salary <= 0 || weeklyWorkload <= 0 || role.equals(""))
			System.out.println(INVALID_ARGUMENTS);
		else {
			ms.addProfessor(name, salary, weeklyWorkload, role);
			System.out.println(PROFESSOR_ADDED);
		}
	}

	private static void addResearcher(Scanner in, ManagementSystem ms) {
		String name = in.next();
		int salary = in.nextInt();
		int weeklyWorkload = in.nextInt();
		String role = in.nextLine().trim();
		String researchGoal = in.nextLine().trim();
		String researchProgress = in.nextLine().trim();

		if (name.equals("") || salary <= 0 || weeklyWorkload <= 0 || role.equals(""))
			System.out.println(INVALID_ARGUMENTS);
		else {
			ms.addResearcher(name, salary, weeklyWorkload, role, researchGoal, researchProgress);
			System.out.println(RESEARCHER_ADDED);
		}
	}


	private static void removeDegree(Scanner in, ManagementSystem ms) {
		String name = in.nextLine().trim();

		if (name.equals(""))
			System.out.println(INVALID_ARGUMENTS);
		else if (!ms.degreeExists(name))
			System.out.println(DEGREE_NOT_EXIST);
		else {
			Degree degree = ms.removeDegree(name);
			System.out.println(degree.getInfo());
			System.out.println(DEGREE_REMOVED);
		}
	}

	private static void removeSubject(Scanner in, ManagementSystem ms) {
		String name = in.nextLine().trim();

		if (name.equals(""))
			System.out.println(INVALID_ARGUMENTS);
		else if (!ms.subjectExists(name))
			System.out.println(SUBJECT_NOT_EXIST);
		else {
			Subject subject = ms.removeSubject(name);
			System.out.println(subject.getInfo());
			System.out.println(SUBJECT_REMOVED);
		}
	}

	private static void removeStudent(Scanner in, ManagementSystem ms) {
		int id = in.nextInt();
		in.nextLine();

		if (id < 0)
			System.out.println(INVALID_ARGUMENTS);
		else if (!ms.studentExists(id))
			System.out.println(STUDENT_NOT_EXIST);
		else {
			Student student = ms.removeStudent(id);
			System.out.println(student.getInfo());
			System.out.println(STUDENT_REMOVED);
		}
	}

	private static void removeProfessor(Scanner in, ManagementSystem ms) {
		int id = in.nextInt();
		in.nextLine();

		if (id < 0)
			System.out.println(INVALID_ARGUMENTS);
		else if (!ms.employeeExists(id))
			System.out.println(PROFESSOR_NOT_EXIST);
		else {
			Professor professor = ms.removeProfessor(id);
			System.out.println(professor.getInfo("Professor"));
			System.out.println(PROFESSOR_REMOVED);
		}
	}

	private static void removeResearcher(Scanner in, ManagementSystem ms) {
		int id = in.nextInt();
		in.nextLine();

		if (id < 0)
			System.out.println(INVALID_ARGUMENTS);
		else if (!ms.employeeExists(id))
			System.out.println(RESEARCHER_NOT_EXIST);
		else {
			Researcher researcher = ms.removeResearcher(id);
			System.out.println(researcher.getInfo("Researcher"));
			System.out.println(RESEARCHER_REMOVED);
		}
	}


	private static void addSubjectToDegree(Scanner in, ManagementSystem ms) {
		String degreeName = in.next();
		String subjectName = in.nextLine().trim();

		if (!ms.subjectExists(subjectName))
			System.out.println(SUBJECT_NOT_EXIST);
		else if (!ms.degreeExists(degreeName))
			System.out.println(DEGREE_NOT_EXIST);
		else {
			ms.addSubjectToDegree(degreeName, subjectName);
			System.out.println(SUBJECT_ADDED_TO_DEGREE);
		}
	}

}
