package cs3250.grading;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GradingTest {

    @Test
    public void testFindGradeByName() {
        double grade = 55.0;
        List<Grades> gradeList = Grades.createList();
        assertEquals(grade, Grades.findGradeByName("rudy", "gobert", gradeList), 0);
    }

    @Test
    public void testFindMaxGrade() {
        List<Grades> gradeList = Grades.createList();
        assertEquals(78.0, Grades.findMaxGrade(gradeList), 0);
    }

    @Test
    public void testFindAverageGrade() {
        List<Grades> gradeList = Grades.createList();
        double average = (34 + 68 + 75 + 55 + 78 + 7) / 6;
        assertEquals(average, Math.floor(Grades.findAverageGrade(gradeList)), 0);
    }

    @Test
    public void testListPeopleByGrade() {
        List<Grades> expected = new ArrayList<Grades>();
        List<Grades> actual = Grades.listPeopleByGrade(Grades.createList());
        expected.add(new Grades("Joe", "ingle", "78"));
        expected.add(new Grades("bojan", "bogdanovic", "75"));
        expected.add(new Grades("Mike","conley","68"));
        expected.add(new Grades("Rudy", "Gobert", "55"));
        expected.add(new Grades("donovan","mitchell", "34"));
        expected.add(new Grades("dante","exum","7"));
        String[] exNames = expected.stream().map(n -> n.getFirstName() + " " + n.getLastName()).toArray(String[]::new);
        String[] acNames = actual.stream().map(n -> n.getFirstName() + " " + n.getLastName()).toArray(String[]::new);
        assertArrayEquals(exNames, acNames);
    }
}