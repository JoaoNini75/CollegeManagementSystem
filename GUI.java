import DegreePackage.Degree;
import DegreePackage.DegreeClass;
import StudentPackage.Student;
import StudentPackage.StudentClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    public static void main(String[] args) {
        createAndShowGUI();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("College Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        GUI demo = new GUI();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        //frame.setSize(600, 400);
        frame.pack();
        frame.setVisible(true);
    }

    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel studentsCard = new JPanel(new BorderLayout(20, 20));/* {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };*/

        JButton btn1 = new JButton("Button 1");
        btn1.setPreferredSize(new Dimension(40, 40));

        studentsCard.add(btn1, BorderLayout.LINE_START);
        studentsCard.add(new JButton("Button 2"), BorderLayout.CENTER);
        studentsCard.add(new JButton("Button 3"), BorderLayout.LINE_END);
        studentsCard.add(initializeStudentTable(), BorderLayout.PAGE_END);

        JPanel professorsCard = new JPanel();
        professorsCard.add(new JTextField("TextField", 20));

        JPanel researchersCard = new JPanel();
        JPanel subjectsCard = new JPanel();
        JPanel degreesCard = new JPanel();

        tabbedPane.addTab("Students", studentsCard);
        tabbedPane.addTab("Professors", professorsCard);
        tabbedPane.addTab("Researchers", researchersCard);
        tabbedPane.addTab("Subjects", subjectsCard);
        tabbedPane.addTab("Degrees", degreesCard);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    private static JTable initializeStudentTable() {
        // Table
        JTable table;

        // Column Names
        String[] columnNames = { "ID", "Name", "Email", "Degree", "Fees paid", "ECTS", "Average", "Semester", "Year" };

        Degree degree = new DegreeClass("Informatica", "Licenciatura", 180, 3, 700);
        Student student1 = new StudentClass(1, "John", degree);
        Student student2 = new StudentClass(2, "Chad", degree);
        List<Student> students = new ArrayList<>(10);
        students.add(student1);
        students.add(student2);

        // Data to be displayed in the JTable
        String[][] data = new String[students.size()][columnNames.length];

        int j = 0;
        for (int i = 0; i < students.size(); i++) {
            data[i][j++] = String.valueOf(students.get(i).getId());
            data[i][j++] = students.get(i).getName();
            data[i][j++] = students.get(i).getEmail();
            data[i][j++] = students.get(i).getDegreeName();
            data[i][j++] = String.valueOf(students.get(i).areFeesPaid());
            data[i][j++] = String.valueOf(students.get(i).getECTS());
            data[i][j++] = String.valueOf(students.get(i).getCourseAverage());
            data[i][j++] = String.valueOf(students.get(i).getSemester());
            data[i][j] = String.valueOf(students.get(i).getYear());
            j = 0;
        }

        // Initializing the JTable
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);

        return table;
    }
}