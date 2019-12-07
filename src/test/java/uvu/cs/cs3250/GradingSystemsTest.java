package uvu.cs.cs3250;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class GradingSystemsTest
{
    @Test
    public void testFindGradeByPerson() {
        List<Student> students = GradingSystems.readFile();
        int grade = GradingSystems.findGradeByStudent(students, "MiKe", "CoNLey");
        int grade2 = GradingSystems.findGradeByStudent(students, "rudy", "gobert");

        assertEquals(grade, 68);
        assertEquals(grade2, 55);
    }

    @Test
    public void testFindStudentByMaxGrade() {
        List<Student> students = GradingSystems.readFile();
        String name = GradingSystems.findStudentWithMaxGrade(students);

        assertEquals(name, "Joe ingle");
    }

    @Test
    public void testGetAvgGrade() {
        List<Student> students = GradingSystems.readFile();
        double grade = GradingSystems.getAvgGrade(students);

        assertEquals(grade, 52.83, .01);
    }

    @Test
    public void testListAllStudents() {
        List<Student> students = GradingSystems.readFile();
        GradingSystems.listAllStudents(students);
    }
}