package TestsPackage;

import org.junit.jupiter.api.Test;
import java.util.List;
import SubjectPackage.*;
import DegreePackage.*;
import StudentPackage.*;
import SystemPackage.*;

class DegreeTests {

    private static final String DEGREE_NAME = "Engenharia Informatica";
    private static final String SUBJECT_NAME = "Introducao a Programacao";

    @Test
    void addRemoveDegree() {
        ManagementSystem ms = new ManagementSystem();
        assert(!ms.degreeExists(DEGREE_NAME));
        ms.addDegree(DEGREE_NAME, "Licenciatura", 180, 3, 700);
        assert(ms.degreeExists(DEGREE_NAME));
        ms.removeDegree(DEGREE_NAME);
        assert(!ms.degreeExists(DEGREE_NAME));
    }

    @Test
    void addRemoveSubjectFromDegree() {
        ManagementSystem ms = new ManagementSystem();
        ms.addDegree(DEGREE_NAME, "Licenciatura", 180, 3, 700);
        ms.addSubject(SUBJECT_NAME, 9, 1, 1, 50);

        assert(!ms.degreeHasSubject(DEGREE_NAME, SUBJECT_NAME));

        ms.addSubjectToDegree(DEGREE_NAME, SUBJECT_NAME);

        boolean correct = false;
        List<Subject> degreeSubjects = ms.listDegreeSubjects(DEGREE_NAME);

        if (degreeSubjects != null) {
            for (int i = 0; i < degreeSubjects.size(); i++)
                if (degreeSubjects.get(i).getName().equals(DEGREE_NAME)) {
                    correct = true;
                    break;
                }
        }

        assert(correct);

        assert(ms.degreeHasSubject(DEGREE_NAME, SUBJECT_NAME));

        ms.removeSubjectFromDegree(DEGREE_NAME, SUBJECT_NAME);

        correct = false;
        degreeSubjects = ms.listDegreeSubjects(DEGREE_NAME);

        if (degreeSubjects != null) {
            for (int i = 0; i < degreeSubjects.size(); i++)
                if (degreeSubjects.get(i).getName().equals(DEGREE_NAME)) {
                    correct = true;
                    break;
                }
        }

        assert(!correct);

        assert(!ms.degreeHasSubject(DEGREE_NAME, SUBJECT_NAME));
    }

}
