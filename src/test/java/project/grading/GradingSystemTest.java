/*
The repo url for this project: https://github.com/mattqfang/cs.3250.projects.grading.git (Links to an external site.)
There is a data file located at src/main/resources. This file contains the data needed for this project. 
Each line of the  file contains 3 columns: first name, last name, grade.

In this project you need to implement the following functions:

1. find the grade for a given person (first name and last name)

2. find out the maximum grade with the name

3. find out the average grade.

4. list all the persons (last name and first name) ordered by the grade

No "loop" or "if" structures  are allowed in this project.
*/

package project.grading;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import project.grading.grading.GradingSystem;

public class GradingSystemTest {
    File f;
    GradingSystem g;

    @Before
    public void setup() {
        f = new File("src/main/resources/data.txt");
        g = new GradingSystem().setFile(f);
        g.createPersonList();
    }

    @Test
    public void checkBadFilePath() {
        File badFile = new File("src/main/resources/bad-data.txt");
        GradingSystem g = new GradingSystem().setFile(badFile);
        assertFalse(g.createPersonList());
    }

    @Test
    public void checkListCreation() {
        assertTrue(g.createPersonList());
    }

    @Test
    public void checkGradeForDonovan() {
        Integer actual = 34;
        assertEquals(g.getGradeByName("Donovan", "Mitchell"), actual);
    }

    @Test
    public void checkGradeForMike() {
        Integer actual = 68;
        assertEquals(g.getGradeByName("Mike", "Conley"), actual);
    }

    @Test
    public void checkGradeForBojan() {
        Integer actual = 75;
        assertEquals(g.getGradeByName("Bojan", "Bogdanovic"), actual);
    }

    @Test
    public void checkGradeForRudy() {
        Integer actual = 55;
        assertEquals(g.getGradeByName("Rudy", "Gobert"), actual);
    }

    @Test
    public void checkGradeForJoe() {
        Integer actual = 78;
        assertEquals(g.getGradeByName("Joe", "Ingle"), actual);
    }

    @Test
    public void checkGradeForDante() {
        Integer actual = 7;
        assertEquals(g.getGradeByName("Dante", "Exum"), actual);
    }

    @Test
    public void checkMaxGrade() {
        String actual = "Ingle, Joe: 78";
        assertEquals(g.getPersonWithMaximumGrade(), actual);
    }

    @Test
    public void checkAverage() {
        BigDecimal avg = new BigDecimal(52.83).setScale(2,RoundingMode.HALF_UP);
        assertEquals(g.getAverageGrade(), avg);
    }

    @Test
    public void checkOrderedList() {
        String actual = Stream.of(
            "Exum, Dante: 7",
            "Mitchell, Donovan: 34",
            "Gobert, Rudy: 55",
            "Conley, Mike: 68",
            "Bogdanovic, Bojan: 75",
            "Ingle, Joe: 78"
        ).collect(Collectors.toList()).toString();
        assertEquals(g.orderByGrade(), actual);
    }

}