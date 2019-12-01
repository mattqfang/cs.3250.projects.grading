package uvu.cs.cs3250.assignments;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

public class GradingSystemTest {
	
	static GradingSystem gs = new GradingSystem();
	
	@Test
	public void testFindGradeByName_1() {
		assertEquals(new Integer(34),
				GradingSystem.findGradeByName("donovan", "mitchell"));
	}
	
	@Test
	public void testFindGradeByName_2() {
		assertEquals(new Integer(7),
				GradingSystem.findGradeByName("Dante", "Exum"));
	}
	
	@Test
	public void testFindGradeByName_3() {
		assertEquals(new Integer(55),
				GradingSystem.findGradeByName("Rudy", "Gobert"));
	}
	
	@Test
	public void testFindGradeByName_False() {
		assertNotEquals(new Integer(88),
				GradingSystem.findGradeByName("Joe", "ingle"));
	}
	
	@Test
	public void testFindGradeByName_Null() {
		assertEquals(null,
				GradingSystem.findGradeByName("Luke", "Skywalker"));
	}
	
	@Test
	public void testFindMaxGradeWithName() {
		assertEquals(Pair.with(78, "Joe ingle"),
				GradingSystem.findMaxGradeWithName());
	}
	
	@Test
	public void testFindGradeAverage() {
		assertEquals(new Double(52.833333333333336),
				GradingSystem.findGradeAverage());
		
	}
	
	@Test
	public void testNameListByGrade() {
		List<String> testList =  new ArrayList<>();
		testList.add("ingle Joe");
		testList.add("bogdanovic bojan");
		testList.add("conley Mike");
		testList.add("Gobert Rudy");
		testList.add("mitchell donovan");
		testList.add("exum dante");
		
		assertEquals(testList,
				GradingSystem.nameListByGrade());
	}
}
