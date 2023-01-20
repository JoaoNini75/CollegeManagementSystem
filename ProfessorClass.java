import java.util.List;

public class ProfessorClass extends EmployeeClass implements Professor  {

    private List<Subject> subjectsTaught;

    public ProfessorClass(int id, String name, int salary, int weeklyWorkload, String role) {
        super(id, name, salary, weeklyWorkload, role);
        this.subjectsTaught = null;
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

}
