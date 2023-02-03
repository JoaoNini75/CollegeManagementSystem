import StudentPackage.Student;
import StudentPackage.StudentClass;
import SystemPackage.ManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIForm {
    private ManagementSystem ms;

    private JPanel mainPanel;
    private JTable[] tables = new JTable[4];
    private JTable studentTable, professorTable, subjectTable, degreeTable;
    private JButton studentAddBtn, studentRemoveBtn;
    private JButton professorAddBtn, professorRemoveBtn;
    private JButton subjectAddBtn, subjectRemoveBtn;
    private JButton degreeAddBtn, degreeRemoveBtn;

    public GUIForm() {
        tables[0] = studentTable;
        tables[1] = professorTable;
        tables[2] = subjectTable;
        tables[3] = degreeTable;

        ms = new ManagementSystem();
        systemMethods(tables);
        GUIMethods(tables);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("College Management System");
        frame.setLocation(100, 100);
        frame.setPreferredSize(new Dimension(700, 500));
        frame.setContentPane(new GUIForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ImageIcon image = new ImageIcon("D:\\IntelliJ IDEA Projects\\CollegeManagementSystem\\images\\clip icon.png");
        frame.setIconImage(image.getImage());
    }

    private void GUIMethods(JTable[] tables) {
        for (int i = 0; i < tables.length; i++)
            setTableTextCenter(tables[i]);
    }

    private void systemMethods(JTable[] tables) {
        initializeStudentTable(tables[0]);
        initializeEmployeeTable(tables[1]);
        initializeSubjectTable(tables[2]);
        initializeDegreeTable(tables[3]);
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
}
