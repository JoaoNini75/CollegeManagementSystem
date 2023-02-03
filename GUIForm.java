import SystemPackage.ManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIForm {

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


    private static final ManagementSystem ms = new ManagementSystem();
    private final JTable[] tables = new JTable[4];

    private JPanel mainPanel;
    private JTable studentTable, professorTable, subjectTable, degreeTable;
    private JButton studentAddBtn, studentRemoveBtn;
    private JButton employeeAddBtn, employeeRemoveBtn;
    private JButton subjectAddBtn, subjectRemoveBtn;
    private JButton degreeAddBtn, degreeRemoveBtn;

    public GUIForm() {
        tables[0] = studentTable;
        tables[1] = professorTable;
        tables[2] = subjectTable;
        tables[3] = degreeTable;

        systemMethods(tables);
        GUIMethods(tables);
        actionListeners();
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("College Management System");
        mainFrame.setLocation(100, 100);
        mainFrame.setPreferredSize(new Dimension(700, 500));
        mainFrame.setContentPane(new GUIForm().mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        ImageIcon image = new ImageIcon("D:\\IntelliJ IDEA Projects\\CollegeManagementSystem\\images\\clip icon.png");
        mainFrame.setIconImage(image.getImage());

        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(mainFrame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    ms.save();
                    System.exit(0);
                }
            }
        });
    }

    private void systemMethods(JTable[] tables) {
        initializeStudentTable(tables[0]);
        initializeEmployeeTable(tables[1]);
        initializeSubjectTable(tables[2]);
        initializeDegreeTable(tables[3]);
    }

    private void GUIMethods(JTable[] tables) {
        for (JTable table : tables) setTableTextCenter(table);
    }

    private void actionListeners() {
        studentAddBtn.addActionListener(e -> {
            System.out.println("Add student");

            // open new frame
            JFrame frame = newFormFrame();

        });

        studentRemoveBtn.addActionListener(e -> System.out.println("Remove student"));

        employeeAddBtn.addActionListener(e -> System.out.println("Add employee"));
        employeeRemoveBtn.addActionListener(e -> System.out.println("Remove employee"));

        subjectAddBtn.addActionListener(e -> System.out.println("Add subject"));
        subjectRemoveBtn.addActionListener(e -> System.out.println("Remove subject"));

        degreeAddBtn.addActionListener(e -> System.out.println("Add degree"));
        degreeRemoveBtn.addActionListener(e -> System.out.println("Remove degree"));
    }

    private JFrame newFormFrame() {
        JFrame frame = new JFrame("College Management System");
        frame.setLocation(100, 100);
        frame.setPreferredSize(new Dimension(700, 500));
        frame.add(new JLabel("Hey"));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ImageIcon image = new ImageIcon("D:\\IntelliJ IDEA Projects\\CollegeManagementSystem\\images\\clip icon.png");
        frame.setIconImage(image.getImage());
        return frame;
    }


    private void initializeStudentTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] columnNames = { "ID", "Name", "Email", "Degree",
                "Fees paid", "ECTS", "Average", "Semester", "Year" };
        model.setDataVector(ms.getStudentTableData(columnNames.length), columnNames);
    }

    private void initializeEmployeeTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] columnNames = { "ID", "Type", "Name", "Salary", "Workload" };
        model.setDataVector(ms.getEmployeeTableData(columnNames.length), columnNames);
    }

    private void initializeSubjectTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] columnNames = { "Name", "ECTS", "Semester", "Year", "Workload" };
        model.setDataVector(ms.getSubjectTableData(columnNames.length), columnNames);
    }

    private void initializeDegreeTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] columnNames = { "Name", "Type", "ECTS", "YearNum", "YearlyFee" };
        model.setDataVector(ms.getDegreeTableData(columnNames.length), columnNames);
    }


    private void setTableTextCenter(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++)
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }


    /*private void addDegree() {
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

    private void addSubject() {
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

    private void addStudent() {
        String name = in.next();
        String degreeName = in.nextLine().trim();

        if (name.equals("") || degreeName.equals(""))
            System.out.println(INVALID_ARGUMENTS);
        else {
            ms.addStudent(name, degreeName);
            System.out.println(STUDENT_ADDED);
        }
    }

    private void addProfessor() {
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

    private void addResearcher() {
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


    private void removeDegree() {
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

    private void removeSubject() {
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

    private void removeStudent() {
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

    private void removeProfessor() {
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

    private void removeResearcher() {
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
    }*/
}
