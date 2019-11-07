import java.util.Optional;

public class Person {
	private String firstName;
	private String lastName;
	private Double grade;
	
	public Person(String firstName, String lastName, double grade) {
		super();
		this.grade = grade;
		this.lastName = cleanAndFormatName(lastName);
		this.firstName = cleanAndFormatName(firstName);
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
	
	public Double getGrade() {
		return grade;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	private String cleanAndFormatName(String name) {
		return name.trim().substring(0,1).toUpperCase() + name.trim().substring(1);
	}
}
