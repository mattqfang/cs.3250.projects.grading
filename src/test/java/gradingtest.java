import static org.junit.Assert.assertEquals;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class gradingtest {
	private grading grades;
	@Before
	public void setUp() {
		grades = new grading();
		grades.readGrades();
	}
	@Test
	public void readGradesTest_Person() {
		Integer finalGrade = 34;
		assertEquals(finalGrade , grades.findGrade("donovan","mitchell"));
	}
	@Test
	public void readGradesTest_Average() {
		Double var = 52.8;
		assertEquals(var , grades.averageGrade(), 0.1);
	}
	@Test
	public void readGradesTest_HighestGrade() {
		assertEquals("joe ingle" , grades.findHighestGrade());
	}
	@Test
	public void readGradesTest_GradesList() {
		assertEquals("joe ingle" , grades.listByGrade().get(0));
		assertEquals("dante exum", grades.listByGrade().get(5));
	}
}