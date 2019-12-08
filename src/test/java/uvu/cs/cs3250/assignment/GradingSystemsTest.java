package uvu.cs.cs3250.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GradingSystemsTest {
	
	@Test
	public void testGradingSystemsFindByName() {
		assertEquals(findByFirstAndLastName("Rudy", "gobert", 55), 55);
	}
	
	@Test
	public void testGradingSystemsGetMaxGrade() {
		assertEquals(findMaxGrade(), 78);
	}
	@Test
	public void testGradingSystemsGetAverage() {
		assertEquals(findAverageGrade(), 52);
	}
	
//	@Test
//	public void testGradingSystemsGetMaxGradeTestDisplay() {
//		assertEquals(printList(),)
//	}
}