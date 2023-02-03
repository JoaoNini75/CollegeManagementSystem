package EmployeePackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import SubjectPackage.*;

public class ProfessorClass extends EmployeeClass implements Professor, Serializable {

    private List<Subject> subjectsTaught;

    public ProfessorClass(int id, String name, int salary, int weeklyWorkload, String role) {
        super(id, name, salary, weeklyWorkload, role);
        this.subjectsTaught = new ArrayList<>(10);
    }

    @Override
    public String getType() {
        return "Professor";
    }

    @Override
    public List<Subject> getSubjectsTaught() {
        return subjectsTaught;
    }

    @Override
    public boolean addSubjectTaught(Subject subjectTaught) {
        if (subjectsTaught.contains(subjectTaught))
            return false;
        subjectsTaught.add(subjectTaught);
        return true;
    }

    @Override
    public boolean removeSubjectTaught(Subject subjectTaught) {
        if (!subjectsTaught.contains(subjectTaught))
            return false;
        subjectsTaught.remove(subjectTaught);
        return true;
    }

    @Override
    public String getInfo(String employeeType) {
        return super.getInfo(employeeType);
    }

}
