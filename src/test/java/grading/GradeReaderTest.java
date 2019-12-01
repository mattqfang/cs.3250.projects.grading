package grading;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GradeReaderTest {

	@Test
	public void testFuncs() throws IOException {
		GradeReader gr = new GradeReader("src\\main\\resources\\data.txt");
		
		// Test get grade
		assertTrue(55 == gr.getGrade("Rudy", "Gobert"));
		assertTrue(-1 == gr.getGrade("foo", "bar"));
		assertTrue(-1 == gr.getGrade(null, null));

		// Test max grade
		assertTrue(78 == gr.maxGrade());
		
		// Test average grade
		double val = (7 + 34 + 55 + 68 + 75 + 78) / 6.0;
		assertTrue(val == gr.avgGrade());
		
		// Display students sorted by grade
		gr.printAll();
	}
	
	@Test
	public void testEmpty() throws IOException {
		GradeReader gr = new GradeReader("src\\main\\resources\\empty.txt");
		
		// Test get grade
		assertTrue(-1 == gr.getGrade("Rudy", "Gobert"));
		assertTrue(-1 == gr.getGrade("foo", "bar"));
		assertTrue(-1 == gr.getGrade(null, null));

		// Test max grade
		assertTrue(-1 == gr.maxGrade());

		// Test average grade
		assertTrue(-1 == gr.avgGrade());
		
		// Display students sorted by grade
		gr.printAll();
	}
	
	// Test IOException for each method
	@Test(expected = IOException.class) 
	public void testIOError() throws IOException {
		GradeReader gr = new GradeReader("foo.bar");
		gr.getGrade("foo", "bar");
	}
	
	@Test(expected = IOException.class) 
	public void testIOError2() throws IOException {
		GradeReader gr = new GradeReader("foo.bar");
		gr.avgGrade();
	}
	
	@Test(expected = IOException.class) 
	public void testIOError3() throws IOException {
		GradeReader gr = new GradeReader("foo.bar");
		gr.printAll();
	}
	
	@Test(expected = IOException.class) 
	public void testIOError4() throws IOException {
		GradeReader gr = new GradeReader("foo.bar");
		gr.maxGrade();
	}

}
