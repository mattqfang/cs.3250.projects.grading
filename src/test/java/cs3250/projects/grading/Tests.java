package cs3250.projects.grading;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Tests {
	Grading grader = new Grading();
	@Test
	public void TestGetGradeFromName() throws Exception {
		assertEquals(grader.GetGradeFromName("donovan mitchell"), 34);
	}
	
	@Test
	public void TestGetMaxGrade() throws Exception {
		assertEquals(grader.GetMaxGrade(), "joe ingle");
	}
	
	@Test
	public void TestGetAverageGrade() throws Exception {
		double answer = (34 + 68 + 75 + 55 + 78 + 7) / 6;
		assertEquals(grader.GetAverageGrade(), answer, 0.1);
	}
	
	@Test
	public void printTest() throws Exception {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
	    String expectedOutput = "ingle, joe\nbogdanovic, bojan\nconley, mike\ngobert, rudy"
	    		+ "\nmitchell, donovan\nexum, dante";
	    
	    grader.PrintSortedList();
	    assertEquals(expectedOutput, outContent.toString());
	}
}
