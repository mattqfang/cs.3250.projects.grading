package gradingSystem;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class GradingSystemTest {
	private GradingSystem gs;
	
	@Before
	public void setUp() {
		gs = new GradingSystem();
	}
	
	@Test
	public void test() {
		//[variable type] [variable name] = gs.[function call];
		//assertEquals( , );
	}
	
	@Test
	public void testAverage() {
		int average = gs.averageGrade();
		assertEquals(53, average);
	}
	
	@Test
	public void findJoeGrade() {
		String first = "joe";
		String last = "ingle";
		assertEquals("joe ingle 78", gs.findGradeByName(first, last));
	}
	
	@Test
	public void findMikeGrade() {
		String first = "Mike";
		String last = "conley";
		assertEquals("mike conley 68", gs.findGradeByName(first, last));
	}
	
	@Test
	public void findGradeGoneWrong() {
		String first = "nope";
		String last = "notHere";
		assertEquals("person not found -1", gs.findGradeByName(first, last));
	}
	
	@Test
	public void testFindMaxGrade() {
		assertEquals("joe ingle 78",gs.findMaxGrade());
	}
	
	
}
