package EmployeePackage;

import java.util.List;
import SubjectPackage.*;

public interface Professor extends Employee {

    List<Subject> getSubjectsTaught();

    boolean addSubjectTaught(Subject subjectTaught);

    boolean removeSubjectTaught(Subject subjectTaught);

}
