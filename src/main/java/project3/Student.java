package project3;

public class Student {

	private String firstName;
	private String lastName;
	private Integer grade;
	
	public Student(String line) {
		String[] data = line.split(",");
		this.firstName = data[0].trim();
		this.lastName = data[1].trim();
		this.grade =  Integer.parseInt(data[2].trim());
	}
	
	public Student(String firstName, String lastName, Integer grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
}
