import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GraderTest {
  private Grader grader;

  @Before
  public void setUp() {
    grader = new Grader();
  }

  @Test
  public void testRecordsLength() {
    int numRecords = grader.getNumRecords();
    assertEquals(numRecords, 6);
  }

  @Test
  public void testGetAverageGrade() {
    double avgGrade = grader.getAverageGrade();
    assertEquals(52.8, avgGrade, 0.09);
  }

  @Test
  public void testListRecordsByGrade() {
    List<String> sortedNames = grader.listRecordsByGrade();
    assertEquals(sortedNames.get(0), "Joe Ingle");
    assertEquals(sortedNames.get(sortedNames.size() - 1), "Dante Exum");
  }

  @Test
  public void testGetScoreByName() {
    int grade = grader.getGrade("dante","exum");
    assertEquals(7, grade);
  }

  @Test
    public void testGetScoreByNameUpperCase() {
    int grade = grader.getGrade("RUDY","GOBERT");
    assertEquals(55, grade);
  }

  @Test
  public void testGetScoreByNameMixedCase() {
    int grade = grader.getGrade("jOE", "InGLe");
    assertEquals(78, grade);
  }

  @Test
  public void testGetNameOfTopScore() {
    String topScorer = grader.getNameOfTopScore();
    assertEquals("Joe Ingle", topScorer);
  }
}
