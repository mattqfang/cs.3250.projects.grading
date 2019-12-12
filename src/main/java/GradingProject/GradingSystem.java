package GradingProject;

public class GradingSystem {
	// Private variables
	private	String firstName;
	private String lastName;
	private int grade;
	
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
	public void setGrade(String string) {
		grade = Integer.parseInt(string);
	}
}
