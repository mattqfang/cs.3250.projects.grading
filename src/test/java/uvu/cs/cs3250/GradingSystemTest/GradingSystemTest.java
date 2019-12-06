package uvu.cs.cs3250.GradingSystemTest;

import org.junit.Before;
import org.junit.Test;

import uvu.cs.cs3250.GradingSystem.StudentRecord;
import uvu.cs.cs3250.GradingSystem.StudentRecordFunctions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;


public class GradingSystemTest {
	private StudentRecordFunctions testFunct;
	private ArrayList<StudentRecord> testList;
	private ArrayList<StudentRecord> tempList;
	
	@Before
	public void setUp() {
	testFunct = new StudentRecordFunctions();
	tempList = testFunct.createRecordList("./src/main/resources/data.txt");
//	testList = new ArrayList<>();  //manually entered info from data.txt if needed
//	testList.add(new StudentRecord("donovan", "mitchell", 34));
//	testList.add(new StudentRecord("Mike", "conley", 68));
//	testList.add(new StudentRecord("bojan", "bogdanovic", 75));
//	testList.add(new StudentRecord("Rudy", "Gobert", 55));
//	testList.add(new StudentRecord("Joe", "ingle", 78));
//	testList.add(new StudentRecord("dante", "exum", 7));
	}
	
	@Test
	public void testCreateRecordList() { 	//checks that file can be read into Arraylist of objects
		testList = new ArrayList<>();
		testList = testFunct.createRecordList("./src/main/resources/data.txt");
		}
	
	@Test
	public void testFindGrade_Normal() {	//checks find grade with name exactly as in file
			int testInt = testFunct.findGrade("donovan", "mitchell", tempList);
			assertEquals(testInt, 34);
	}
	
	@Test
	public void testFindGrade_UpperCase() {		//checks find grade with name all uppercase
			int testInt = testFunct.findGrade("RUDY", "GOBERT", tempList);
			assertEquals(testInt, 55);
	}
	
	@Test
	public void testFindGrade_InvalidName() {		//checks find grade with invalid name
			int testInt = testFunct.findGrade("Karl", "Malone", tempList);
			assertEquals(testInt, 0);
	}
	
	@Test
	public void testHighestGrade() {		//checks highest grade
			String testString = testFunct.highestGrade(tempList);
			assertEquals(testString, "Joe ingle, Grade: 78");
	}
	
	@Test
	public void testAverageGrade() {		//checks average grade
			double testAverage = testFunct.averageGrade(tempList);
			assertEquals(testAverage, 52.833333333333336, 0);
	}
	
	@Test
	public void testOrderByGrade() {		//checks orderbygrade
			testFunct.orderByGrade(tempList);	
	}


}
