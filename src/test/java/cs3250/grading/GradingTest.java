package cs3250.grading;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
        String[] expected = {"ingle, Joe", "bogdanovic, bojan", "conley, Mike", "Gobert, Rudy", "mitchell, donovan", "exum, dante"};
        String[] actual = Grades.listPeopleByGrade(Grades.createList()).stream().map(n -> n.getLastName() + ", " + n.getFirstName()).toArray(String[]::new); 
        assertArrayEquals(expected, actual);
    }
}