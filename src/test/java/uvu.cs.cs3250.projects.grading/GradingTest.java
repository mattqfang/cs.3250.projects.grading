package uvu.cs.cs3250.projects.grading;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static uvu.cs.cs3250.projects.grading.Grading.*;

public class GradingTest {
    private File file = new File(getClass().getClassLoader().getResource("data.txt").getFile());
    private String filePath = file.getAbsolutePath();

    @Test
    public void testGettingStudentGrade() {
        int studentGrade = getStudentGrade("Donovan", "Mitchell", filePath);
        assertEquals(34, studentGrade);
    }
    @Test
    public void testFindStudentNotInFile() {
        int studentGrade = getStudentGrade("Harry", "Potter", filePath);
        assertEquals(0, studentGrade);
    }
    @Test
    public void testFindGradeNullStudent() {
        int studentGrade = getStudentGrade(null, null, filePath);
        assertEquals(0, studentGrade);
    }

    @Test
    public void testGettingMaxScore() {
        String maxGradePerson = getMaxGrade(filePath);
        assertEquals("ingle, Joe, 78", maxGradePerson);
    }
    @Test
    public void testAverageGrade() {
        int aveGrade = getAverageGrade(filePath);
        assertEquals(53, aveGrade);
    }
    @Test
    public void testListStudentsByGrade(){
        String testStr = "ingle, Joe, 78\n" +
                "bogdanovic, bojan, 75\n" +
                "conley, Mike, 68\n" +
                "Gobert, Rudy, 55\n" +
                "mitchell, donovan, 34\n" +
                "exum, dante, 7";
        assertEquals(testStr, printStudentsByHighGrade(filePath));
    }

}
