
public class Student {
	String firstName;
	String lastName;
	Integer grade;
	
	public Student(String firstName, String lastName, Integer grade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public Student setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Student setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
	public Student setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}
	
	public String toString() {
		return firstName + " " + lastName + " " + grade;
	}
}
