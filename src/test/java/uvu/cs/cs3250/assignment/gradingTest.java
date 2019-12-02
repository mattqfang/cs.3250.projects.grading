package uvu.cs.cs3250.assignment;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class gradingTest {
	private uvu.cs.cs3250.assignment.grading grading;
	
	@Before
	public void setUp() {
		grading = new grading();
	}
	
	@Test
	public void testGetMax() {
		
		String max = grading.getMaxGrade();
		assertEquals("joe ingle 78", max);
	}
	

	@Test
	public void testGetAve() {
		double ave = grading.getAverageGrade();
		double expected = 317.0/6.0;
		assertEquals(expected, ave, 0.001);
	}
	@Test
	public void getGradeDonovan() {
		String firstName = "donovan";
		String secondName = "mitchell";
		int grade = grading.getGrade(firstName, secondName);
		assertEquals(34, grade);
	}
	@Test
	public void getGradeMike() {
		String firstName = "Mike";
		String secondName = "Conley";
		int grade = grading.getGrade(firstName, secondName);
		assertEquals(68, grade);
	}
	
	
	@Test
	public void testStream() {
		grading.showOrderedGrades();
	}
}
