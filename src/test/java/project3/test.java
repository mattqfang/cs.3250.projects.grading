package project3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import org.junit.Before;
import org.junit.Test;

public class test {
	
	@Test
	public void testfindGrade() {
		List<Student> student = project3.main();
		
		int grade = project3.findGradebyName("Rudy", "Gobert", student);
		assertEquals(55,grade);
	}

	@Test
	public void findMax() {
		List<Student> student = project3.main();
		
		String target = project3.findMaxgrade(student);
		assertEquals("Joe",target);
	}
	
	@Test
	public void findAverage() {
		List<Student> student = project3.main();
		
		OptionalDouble target = project3.findAverage(student);
		System.out.println("The average should be 52.83, the stream get " + target);
	}
	
	@Test
	public void list() {
		List<Student> student = project3.main();
		
		project3.listbyGrade(student);
	}
}
