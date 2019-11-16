import cs3250.projects.grading.DatabaseReader;
import cs3250.projects.grading.GradeLookupUtils;
import cs3250.projects.grading.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static cs3250.projects.grading.GradeLookupUtils.getGradeByName;
import static cs3250.projects.grading.GradeLookupUtils.getStudentsOrderedByGrade;
import static org.junit.Assert.assertEquals;


public class UtilsTest {
    private List<Student> db;

    @Before
    public void setup() {
        this.db = new DatabaseReader("src\\main\\resources\\data.txt").getStudents();
    }

    @Test
    public void testName() {
        Integer score = GradeLookupUtils.getGradeByName("dante", "exum", db);
        assertEquals((Integer)7, score);
    }

    @Test
    public void testName2() {
        Integer score = GradeLookupUtils.getGradeByName("kyle", "gray", db);
        assertEquals(null, score);
    }

    @Test
    public void testGetMaxGrade() {
        String name = GradeLookupUtils.getMaxGradeWithName(db);
        assertEquals("Joe ingle: 78", name);
    }

    @Test
    public void testGetAverageGrade() {
        Double grade = GradeLookupUtils.getAverageGrade(db);
        assertEquals(52.833, grade, .1);
    }

    @Test
    public void testGetSortedList() {
        List<String> expectedNames = Arrays.asList("Joe ingle", "bojan bogdanovic", "Mike conley", "Rudy Gobert", "donovan mitchell", "dante exum");
        List<String> names = GradeLookupUtils.getStudentsOrderedByGrade(db);
        assertEquals(expectedNames, names);
    }



} 
