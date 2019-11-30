package uvu.cs.cs3250.assignments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GradingTest {
	
	@Test
	public void testFindGrade() {
		assertEquals(Grading.FindGrade("donovan", "mitchell"), "34");
	}
	
	@Test
	public void testFindGrade2() {
		assertEquals(Grading.FindGrade("dante", "exum"), "7");
	}
	
	@Test
	public void testHighestGrade() {
		assertEquals(Grading.FindHighestGrade(), "Joe, ingle, 78");
	}
}