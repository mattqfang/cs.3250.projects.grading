package uvu.cs.cs3250.assignments;

public class Student{
	private String firstName;
	private String lastName;
	private Integer grade;
	
	public Student(String last, String first, Integer percent) {
		lastName = last;
		firstName = first;
		grade = percent;
	}
	public void setFirstName(String name) {
		firstName = name;
	}
	public String getFirstName() { return firstName;}
	public void setLastName(String name) {
		lastName = name;
	}
	public String getLastName() { return lastName;}
	public void setGrade(Integer percent) {
		grade = percent;
	}
	public Integer getGrade() { return grade;}
}
