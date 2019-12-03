package uvu.cs3250.projects.grading;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class GradingTest {
    @Test
    public void testGetGradeByName() {
        Grading.setupGrades();
        Assert.assertEquals(68, Grading.getGradeByName("Mike", "Conley"));
    }

    @Test
    public void testGetMaxGradeWithName() {
        Grading.setupGrades();
        Grading.IndividualGrade ind = Grading.getMaxGradeWithName();
        Assert.assertTrue(ind.getGrade() == 78 && ind.getFullName().equalsIgnoreCase("Joe Ingle"));
    }

    @Test
    public void testGetAverageGrade(){
        Grading.setupGrades();
        double avg = Grading.getAverageGrade();
        Assert.assertTrue(Math.floor(avg) == 52);
    }

    @Test
    public void testGetAllGradesOrdered(){
        Grading.setupGrades();
        List<Grading.IndividualGrade> orderedGrades = Grading.getAllGradesOrdered();
        Assert.assertTrue(orderedGrades.size() == 6 && orderedGrades.get(0).getFullName().equalsIgnoreCase("Dante Exum"));
    }
}

