package uvu.cs.cs3250.grading;

public class Person 
{
	private String firstname;
	private String lastname;
	private int grade;
	
	public void setFirstName(String firstname) { this.firstname = firstname; }
	public String getFirstName() { return this.firstname; }
	public void setLastName(String lastname) { this.lastname = lastname; }
	public String getLastName() { return this.lastname; }
	public void setGrade(int grade) { this.grade = grade; }
	public int getGrade() { return this.grade; }
	
	public Person(String firstname, String lastname, int grade)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.grade = grade;
	}
	
	@Override
	public String toString() { return this.firstname + " " + this.lastname + " (" + this.grade + ")"; }
}
