package project3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class test {
	@Test
	public void testfindGrade() {
		List<Student> student = new ArrayList<>();
		student.add(new Student("donovan","mitchell",34));
		student.add(new Student("Mike","conley",68));
		student.add(new Student("bojan", "bogdanovic", 75));
		student.add(new Student("Rudy", "Gobert", 55));
		student.add(new Student("Joe", "ingle", 78));
		student.add(new Student("dante","exum",7));
		
		int grade = findGradebyName("Rudy", "Gobert",student);
		assertEquals(55,grade);
	}

}
