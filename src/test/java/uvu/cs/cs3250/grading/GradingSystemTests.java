package uvu.cs.cs3250.grading;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import uvu.cs.cs3250.grading.GradingSystem;
import uvu.cs.cs3250.grading.Person;

public class GradingSystemTests
{	
	@Test
	public void testFindGradeByPerson()
	{
		List<Person> persons = GradingSystem.readFile("src/main/resources/data.txt");
		int grade = GradingSystem.findGradeByPerson(persons, "Joe", "Ingle");
		
		assertEquals(grade, 78);
	}
	
	@Test
	public void testFindNameByMaxGrade()
	{
		List<Person> persons = GradingSystem.readFile("src/main/resources/data.txt");
		String name = GradingSystem.findNameWithMaxGrade(persons);
		
		assertEquals(name, "Joe ingle");
	}
	
	@Test
	public void testGetAvgGrade()
	{
		List<Person> persons = GradingSystem.readFile("src/main/resources/data.txt");
		double grade = GradingSystem.getAvgGrade(persons);
		
		assertEquals(grade, 52.83, .01);
	}
}
