package TestsPackage;

import org.junit.jupiter.api.Test;
import java.util.List;
import SubjectPackage.*;
import DegreePackage.*;
import StudentPackage.*;
import SystemPackage.*;

class StudentTests {

    private static final String DEGREE_NAME = "Engenharia Informatica";
    private static final String SUBJECT_NAME = "Introducao a Programacao";

    @Test
    void StudentEmail() {
        Degree degree = new DegreeClass(DEGREE_NAME, "Licenciatura", 180, 3, 700);
        Student student = new StudentClass(34, "John", degree);
        assert(student.getEmail().equals("34@ourCollege.com"));
    }
}

