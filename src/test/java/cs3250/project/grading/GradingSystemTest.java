package cs3250.project.grading;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GradingSystemTest {
    private GradingSystem Grades = new GradingSystem();

    @Test
    public void searchForStudent() {
        assertEquals("Bogdanovic, Bojan: 75%", Grades.SearchStudent("Bojan", "Bogdanovic"));
    }

    @Test
    public void searchForMissingStudent() {
        assertEquals("Benny Goodman is not present in list", Grades.SearchStudent("Benny", "Goodman"));
    }

    @Test
    public void searchCaseSensitiveStudent() {
        assertEquals("Bogdanovic, Bojan: 75%", Grades.SearchStudent("bOJaN", "bogDAnOvIc"));
    }

    @Test
    public void retrieveHighestGradeInList() {
        assertEquals("Ingle, Joe: 78%", Grades.getHighestGrade());
    }

    @Test
    public void retrieveAverageGrade() {
        Double expected = 52.83;
        assertEquals(expected, Grades.getAverageGrade());
    }

    @Test
    public void orderedStudentList() {
        List<Person> sorted = new ArrayList<Person>();
        sorted.add(new Person("Joe", "Ingle", 78));
        sorted.add(new Person("Bojan", "Bogdanovic", 75));
        sorted.add(new Person("Mike", "Conley", 68));
        sorted.add(new Person("Rudy", "Gobert", 55));
        sorted.add(new Person("Donovan", "Mitchell", 34));
        sorted.add(new Person("Dante", "Exum", 7));

        assertEquals(sorted.get(0).toString(), Grades.orderByGrade().get(0).toString());
        assertEquals(sorted.get(1).toString(), Grades.orderByGrade().get(1).toString());
        assertEquals(sorted.get(2).toString(), Grades.orderByGrade().get(2).toString());
        assertEquals(sorted.get(3).toString(), Grades.orderByGrade().get(3).toString());
        assertEquals(sorted.get(4).toString(), Grades.orderByGrade().get(4).toString());
        assertEquals(sorted.get(5).toString(), Grades.orderByGrade().get(5).toString());
    }
}
