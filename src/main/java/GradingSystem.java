/*import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;*/

public class GradingSystem {
	// Private variables
	private	String firstName;
	private String lastName;
	private int grade;
	
	GradingSystem() {
/* // Modified From an online tutorial about stream inputs
		String fileName = "c://data.txt";
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			//1. filter line 3
			//2. convert all content to upper case
			//3. convert it into a List
			list = stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
// end modified */
	}
	
	// Getters and Setters
	public int getGrade() {
		return grade;
	}
	public Integer getGradeInteger() {
		return (Integer) grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Methods
	
	public String getName() {
		return firstName + lastName;
	}
}
