import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GradingTest {
	private Grading grading;

	@Before
	public void setUp() throws IOException {
		grading = new Grading();
	}
	
	@Test
	public void testGradeOfPersonInList() {
		assertEquals(7.0, grading.getGradeByPerson("dante", "exum"), .1);
	}
	
	@Test
	public void testGradeOfPersonInListIgnoreCase() {
		assertEquals(68.0, grading.getGradeByPerson("MiKe", "ConLEy"), .1);
	}
	
	@Test
	public void testGradeOfPersonNotInList() {
		assertEquals(-1.0, grading.getGradeByPerson("dantxe", "exum"), .1);
	}
	
	@Test
	public void testGetMaxGradeWithName() {
		assertEquals("Joe Ingle 78.0", grading.getMaxGradeWithName());
	}

	@Test
	public void testNullAvgGrade() {
		assertEquals(52.83, grading.getAvgGrade(), 0.09);
	}
	
	@Test
	public void testGetSortedList() {
		assertEquals("Ingle, Joe 78.0", grading.gradeListOrderedByGrade().get(0));
		assertEquals("Bogdanovic, Bojan 75.0", grading.gradeListOrderedByGrade().get(1));
		assertEquals("Conley, Mike 68.0", grading.gradeListOrderedByGrade().get(2));
		assertEquals("Gobert, Rudy 55.0", grading.gradeListOrderedByGrade().get(3));
		assertEquals("Mitchell, Donovan 34.0", grading.gradeListOrderedByGrade().get(4));
		assertEquals("Exum, Dante 7.0", grading.gradeListOrderedByGrade().get(5));
	}
}
