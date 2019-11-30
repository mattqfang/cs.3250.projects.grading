import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException; 
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GradesTest {
	private static final Double DELTA = .1;

	private Grades grades;
	private String resource_name = "data.txt";

	@Before
	public void init() throws IOException, URISyntaxException {
		URL url = GradesTest.class.getResource(resource_name);
		Path resource_path = Paths.get(url.toURI());
		grades = new Grades(resource_path);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNull() {
		assertEquals(7.0, grades.getGradeByName(null, null), DELTA);
	}
	@Test
	public void testGradeOfPersonInList() {
		assertEquals(7.0, grades.getGradeByName("dante", "exum"), DELTA);
	}
	@Test
	public void testIgnoreCase() {
		assertEquals(7.0, grades.getGradeByName("dAnTe", "ExuM"), DELTA);
	}
	@Test
	public void testIgnoreSpace() {
		assertEquals(7.0, grades.getGradeByName("dante ", " exum"), DELTA);
	}

	@Test (expected = NoSuchElementException.class)
	public void testGradeOfPersonNotInList() {
		assertEquals(7.0, grades.getGradeByName("Billie", "Ellish"), DELTA);
	}

	@Test
	public void testGetMaxGrade() {
		assertEquals("Joe Ingle (78.0)", grades.getMaxGrade());
	}

	@Test
	public void testAverageGrade() {
		assertEquals(52.83, grades.getAverageGrade(), DELTA);
	}

	@Test
	public void testGetSortedListLength() {
		List<String> sorted_list = grades.getAllByGrade();
		assertEquals(6, sorted_list.size());
	}
	@Test
	public void testGetSortedListValues() {
		List<String> sorted_list = grades.getAllByGrade();
		assertEquals("Joe Ingle (78.0)"       , sorted_list.get(0));
		assertEquals("Bojan Bogdanovic (75.0)", sorted_list.get(1));
		assertEquals("Mike Conley (68.0)"     , sorted_list.get(2));
		assertEquals("Rudy Gobert (55.0)"     , sorted_list.get(3));
		assertEquals("Donovan Mitchell (34.0)", sorted_list.get(4));
		assertEquals("Dante Exum (7.0)"       , sorted_list.get(5));
	}
}
