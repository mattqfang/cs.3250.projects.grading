import static org.junit.Assert.*;
import org.junit.Test;

public class GradingTest {

	@Test
	public void ReadTestRudy() throws Exception
	{
		Grading grade = new Grading();
		String first = "Rudy";
		String last = "Gobert";
		int result = grade.FindGrade(first, last);
		assertEquals(55, result);
		
	}
	
	@Test
	public void ReadTestDante() throws Exception
	{
		Grading grade = new Grading();
		String first = "dante";
		String last = "exum";
		int result = grade.FindGrade(first, last);
		assertEquals(7, result);
		
	}
	
	@Test
	public void ReadTestJoe() throws Exception
	{
		Grading grade = new Grading();
		String first = "Joe";
		String last = "ingle";
		int result = grade.FindGrade(first, last);
		assertEquals(78, result);
		
	}
	
	@Test
	public void FindMaxGradeTest() throws Exception
	{
		Grading maxGrade = new Grading();
		int result = maxGrade.FindMaxGrade();
		assertEquals(78, result);
		
	}
	
	@Test
	public void FindAverageGradeTest() throws Exception
	{
		Grading avgGrade = new Grading();
		double result = avgGrade.FindAverageGrade();
		int roundedResult = (int)result;
		assertEquals(52, roundedResult);

		
	}
}