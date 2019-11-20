import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;


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
	public void nullFileName() {
		assertFalse(Grades.InitializeList(null));
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
		assertEquals(null, Grades.findGradeByPerson(null, null));
	}
	
	@Test
	public void findGradeByPerson_ignoreCase() {
		Integer expectedGrade = 75;
		Grades.InitializeList(filepath);
		assertEquals(expectedGrade, Grades.findGradeByPerson("bOjaN", "Bogdanovic"));
	}
	
	@Test
	public void findMaxGradeWithName() {
		Grades.InitializeList(filepath);
		assertEquals("joe ingle: 78", Grades.findMaxGrade());
	}
	
	@Test
	public void findAverageGrade() {
		Grades.InitializeList(filepath);
		double expectedAverage = (34+68+75+55+78+7)/6.0;
		assertTrue(Grades.findAverageGrade() == expectedAverage);		
	}
	
	@Test
	public void listAllPeopleByGrade() {
		Grades.InitializeList(filepath);
		String expectedString = "joe ingle 78\n"
				+ "bojan bogdanovic 75\n"
				+ "mike conley 68\n"
				+ "rudy gobert 55\n"
				+ "donovan mitchell 34\n"
				+ "dante exum 7";
		assertTrue(expectedString.equals(Grades.listPersonsByGrade()));
	}
	
}
