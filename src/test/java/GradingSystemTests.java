import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import project3.GradeFunctions;

public class GradingSystemTests {
	GradeFunctions gf = new GradeFunctions();

	@Test
	public void testGetGradeForName() {
		assertEquals(gf.getGradeForName("joe", "ingle"), 78);
	}
	
	@Test
	public void testFindHighestGradeStudent() {
		String highest = gf.getMaxGrade();
		assertEquals(highest, "Joe ingle");
	}
	
	@Test
	public void testFindAverageGrade() {
		double average = 52.83;
		assertEquals(gf.getAvgGrade(), average, 2);
	}
	
	@Test
	public void testListStudentByGrade() {
		List<String> list = gf.ListStudentsByGrade();
		String item = "conley, Mike";
		assertEquals(list.get(2), item);
	}

}
