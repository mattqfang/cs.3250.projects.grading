package uvu.cs.cs3250.assignment;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class gradingTest {
//	private Grading grading;
//	
//	@Before
//	public void setUp() {
//		grading = new grading();
//	}
//	
//	@Test
//	public void testGetMax() {
//		List<Integer> data = Arrays.asList(1, 3, 8, 4, 6);
//		int max = streamer.getMax(data);
//		assertEquals(8, max);
//	}
//	
//	@Test
//	public void testGetMin() {
//		List<Integer> data = Arrays.asList(1, 3, 8, 4, 6);
//		int min = streamer.getMin(data);
//		assertEquals(1, min);
//	}
	
	@Test
	public void testStream() {
		grading.showOrderedGrades();
	}
}
