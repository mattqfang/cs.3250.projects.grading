package uvu.cs.cs3250;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class gradesTest {
	@Test
	public void FindGradeTestSuccess(){
		grades EXAMPLE = new grades();
		int foundGrade = EXAMPLE.FindGrade("Donovan", "Mitchell");
		assertEquals(foundGrade, 34);
		// When a person is found with the given name the score is that person's score
	}
	@Test
	public void FindGradeTestBadName(){
		grades EXAMPLE = new grades();
		int foundGrade = EXAMPLE.FindGrade("Danny", "Sable");
		assertEquals(foundGrade, -1);
		// -1 means that nobody was found with a given name
	}
	@Test
	public void FindGradeTestDuplicate(){
		grades EXAMPLE = new grades();
		int foundGrade = EXAMPLE.FindGrade("Kip", "Summers");
		assertEquals(foundGrade, -2);
		// -2 means that more than one person was found with a given name.
	}
	@Test
	public void FindMaxGradeTest(){
		grades EXAMPLE = new grades();
		Person maxGradeStudent = EXAMPLE.FindMaxGrade();
		assertEquals(maxGradeStudent.getFirstName(), "Joe");
		assertEquals(maxGradeStudent.getLastName(), "Ingle");
		assertEquals(maxGradeStudent.getGrade(), 78);
	}
	@Test
	public void FindAvgGradeTest(){
		grades EXAMPLE = new grades();
		int avgGrade = EXAMPLE.FindAvgGrade();
		assertEquals(avgGrade, 53);
	}
	@Test
	public void ListPersonsByGradeOrderTest(){
		grades EXAMPLE = new grades();
		EXAMPLE.ListPersonsByGradeOrder();	
		// there is no test for this because I wasn't sure how to test for it.
	}
}
