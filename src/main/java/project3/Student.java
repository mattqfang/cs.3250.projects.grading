package project3;

public class Student {
	private String firstName;
	private String lastName;
	private Integer Grade;
	
	public Student(String firstName, String lastName, Integer Grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.Grade = Grade;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public Integer getGrade() {
		return Grade;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setGrade(Integer Grade) {
		this.Grade = Grade;
	}
}
