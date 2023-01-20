import java.util.List;

public interface Professor extends Employee {

    List<Subject> getSubjectsTaught();

    boolean addSubjectTaught(Subject subjectTaught);

    boolean removeSubjectTaught(Subject subjectTaught);
}
