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
		assertEquals(7.0, grading.GetGradeByPerson("dante", "exum"), .1);
	}
	
	@Test
	public void testGradeOfPersonNotInList() {
		assertEquals(-1.0, grading.GetGradeByPerson("dantxe", "exum"), .1);
	}
	
	@Test
	public void testGetMaxGradeWithName() {
		assertEquals("Joe Ingle 78.0", grading.GetMaxGradeWithName());
	}

	@Test
	public void testNullAvgGrade() {
		assertEquals(52.83, grading.GetAvgGrade(), 0.09);
	}
	
	@Test
	public void testGetSortedList() {
		assertEquals("Joe Ingle 78.0", grading.GradeListOrderedByGrade().get(0));
		assertEquals("Bojan Bogdanovic 75.0", grading.GradeListOrderedByGrade().get(1));
		assertEquals("Mike Conley 68.0", grading.GradeListOrderedByGrade().get(2));
		assertEquals("Rudy Gobert 55.0", grading.GradeListOrderedByGrade().get(3));
		assertEquals("Donovan Mitchell 34.0", grading.GradeListOrderedByGrade().get(4));
		assertEquals("Dante Exum 7.0", grading.GradeListOrderedByGrade().get(5));		
	}
}
