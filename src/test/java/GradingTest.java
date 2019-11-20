import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/*
4. list all the persons (last name and first name) ordered by the grade
*/

public class GradingTest {
	
	File file = new File(
			getClass().getClassLoader().getResource("data.txt").getFile()
		);
	String filepath = file.getAbsolutePath();
	
	@Test
	public void failedFileName() {
		assertFalse(Grades.InitializeList("C:/NotAPath/"));
	}
	
	@Test
	public void successfulFileOpen() {
		assertTrue(Grades.InitializeList(filepath));
	}
	
	@Test
	public void findGradeByPerson_inList() {
		Integer expectedGrade = 34;
		Grades.InitializeList(filepath);
		assertEquals(expectedGrade, Grades.findGradeByPerson("donovan", "mitchell"));
	}
	
	@Test
	public void findGradeByPerson_notInList() {
		Grades.InitializeList(filepath);
		assertEquals(null, Grades.findGradeByPerson("george", "little"));
	}
	
	@Test
	public void findGradeByPerson_null() {
		Grades.InitializeList(filepath);
		assertEquals(null, Grades.findGradeByPerson("george", null));
	}
	
	@Test
	public void findMaxGradeWithName() {
		Grades.InitializeList(filepath);
		assertEquals("joe ingle: 78", Grades.findMaxGrade());
	}
	
	@Test
	public void findAverageGrade() {
		Grades.InitializeList(filepath);
		double average = (34+68+75+55+78+7)/6.0;
		assertTrue(Grades.findAverageGrade() == average);		
	}
	
	
	@Test
	public void listAllPeopleByGrade() {
		
	}
	
}
