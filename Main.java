import java.util.Scanner;

public class Main {

	/**
	 * Comandos do utilizador.
	 */
	private static final String HELP = "HELP";
	private static final String ADD_DEGREE = "ADD DEGREE";
	private static final String ADD_SUBJECT = "ADD SUBJECT";
	private static final String ADD_STUDENT = "ADD STUDENT";
	private static final String ADD_PROFESSOR = "ADD PROFESSOR";
	private static final String ADD_RESEARCHER = "ADD RESEARCHER";

	private static final String REMOVE_DEGREE = "REMOVE DEGREE";
	private static final String REMOVE_SUBJECT = "REMOVE SUBJECT";
	private static final String REMOVE_STUDENT = "REMOVE STUDENT";
	private static final String REMOVE_PROFESSOR = "REMOVE PROFESSOR";
	private static final String REMOVE_RESEARCHER = "REMOVE RESEARCHER";

	private static final String ADD_SUBJECT_TO_DEGREE = "ADD SUBJECT TO DEGREE";



	private static final String EXIT = "EXIT";

	/**
	 * Feedback dado pelo programa.
	 */
	private static final String WELCOME = "Welcome to the college management system :)\nType help to get the list of the available commands.";
	private static final String PRINT_HELP = "TODO";
	private static final String DEGREE_EXISTS = "Degree already exists.";
	private static final String DEGREE_ADDED = "Degree added.";
	private static final String DEGREE_NOT_EXIST = "Degree does not exist.";
	private static final String DEGREE_REMOVED = "Degree removed.";
	private static final String SUBJECT_ADDED_TO_DEGREE = "Subject added to degree";
	private static final String SUBJECT_NOT_EXIST = "Subject does not exist";

	private static final String EXITING = "Exiting...";

	public static void main(String[] args) {
		commands();
	}

	private static void commands() {
		ManagementSystem ms = new ManagementSystem();
		Scanner in = new Scanner(System.in);
		System.out.println(WELCOME);
		String userIn = in.next().toUpperCase();
		while (!userIn.equals(EXIT)) { //TODO resolver problema comandos c/ varias palavras
			switch (userIn) {
				case HELP:
					System.out.println(PRINT_HELP);
					break;
				case ADD_DEGREE:
					System.out.println("0");
					addDegree(in, ms);
					break;
				case ADD_SUBJECT:
					addSubject(in, ms);
					break;
				case ADD_STUDENT:
					addStudent(in, ms);
					break;
				case ADD_PROFESSOR:
					addProfessor(in, ms);
					break;
				case ADD_RESEARCHER:
					addResearcher(in, ms);
					break;

				case REMOVE_DEGREE:
					removeDegree(in, ms);
					break;

				case ADD_SUBJECT_TO_DEGREE:
					addSubjectToDegree(in, ms);
					break;

				default:
					break;
			}
			userIn = in.next().toUpperCase();
		}
		System.out.println(EXITING);
		in.close();
	}

	private static void addDegree(Scanner in, ManagementSystem ms) {
		System.out.println("1");
		String name = in.next();
		String type = in.next();
		int ects = in.nextInt();
		int yearNum = in.nextInt();
		int yearlyFee = in.nextInt();
		in.nextLine();
		System.out.println("2");
		if (ms.degreeExists(name))
			System.out.println(DEGREE_EXISTS);
		else {
			ms.addDegree(name, type, ects, yearNum, yearlyFee);
			System.out.println(DEGREE_ADDED);
		}
	}

	private static void addSubject(Scanner in, ManagementSystem ms) {

	}

	private static void addStudent(Scanner in, ManagementSystem ms) {

	}

	private static void addProfessor(Scanner in, ManagementSystem ms) {

	}

	private static void addResearcher(Scanner in, ManagementSystem ms) {

	}



	private static void removeDegree(Scanner in, ManagementSystem ms) {
		String name = in.next();
		in.nextLine();

		if (!ms.degreeExists(name))
			System.out.println(DEGREE_NOT_EXIST);
		else {
			ms.removeDegree(name);
			System.out.println(DEGREE_REMOVED);
		}
	}


	private static void addSubjectToDegree(Scanner in, ManagementSystem ms) {
		int subjectId = in.nextInt();
		String name = in.nextLine().trim();

		if (!ms.subjectExists(subjectId))
			System.out.println(SUBJECT_NOT_EXIST);
		else if (!ms.degreeExists(name))
			System.out.println(DEGREE_NOT_EXIST);
		else {
			ms.addSubjectToDegree(subjectId, name);
			System.out.println(SUBJECT_ADDED_TO_DEGREE);
		}
	}





	/**
	 * Lista todos os ficheiros proprietarios e partilhados de uma conta.
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dropbox - o CloudSharing a listar a informacao de uma conta.
	 */
	/*private static void listFiles(Scanner in, CloudSharing dropbox) {
		String user = in.next();
		if (!dropbox.hasUser(user))
			System.out.println(ACCOUNT_DOES_NOT_EXIST);
		else {
			System.out.println(HEADER_LIST_FILES);
			Iterator<File> it = dropbox.listFiles(user);
			while (it.hasNext()) {
				File file = (File) it.next();
				if (!file.getOwnerName().equals(user))
					System.out.printf(SHARED_FILE_INFO, file.getName(), file.getSize());
				else
					System.out.printf(OWNED_FILE_INFO, file.getName(), file.getSize());
			}
			System.out.println();
		}
	}*/

	/**
	 * Lista todas as contas.
	 * @param dropbox - o CloudSharing a listar as contas.
	 */
	/*private static void listAccounts(CloudSharing dropbox) {
		Iterator<User> it =  dropbox.listAll();
		System.out.println(HEADER_LIST_ACCOUNTS);
		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.printf(ACCOUNT_INFO, user.getName(), user.getType());
		}
		System.out.println();

	}*/
}
