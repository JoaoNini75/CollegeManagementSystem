import java.util.List;

public class ProfessorClass extends EmployeeClass implements Professor  {

    private List<Subject> subjectsTaught;

    public ProfessorClass(int id, String name, int salary, int weeklyWorkload, String role, List<Subject> subjectsTaught) {
        super(id, name, salary, weeklyWorkload, role);
        this.subjectsTaught = subjectsTaught;
    }

    @Override
    public List<Subject> getSubjectsTaught() {
        return subjectsTaught;
    }

    @Override
    public void setSubjectsTaught(List<Subject> subjectsTaught) {
        this.subjectsTaught = subjectsTaught;
    }
}
