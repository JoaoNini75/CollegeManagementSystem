import java.util.List;

public interface Professor extends Employee {

    List<Subject> getSubjectsTaught();

    void setSubjectsTaught(List<Subject> subjectsTaught);
}
