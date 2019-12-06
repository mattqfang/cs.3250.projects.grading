package uvu.cs.cs3250.GradingSystem;

public class StudentRecord {
	private String firstName;
	private String lastName;
	private Integer Grade;
	
	public StudentRecord(String line) {		//Constructor that allows parsing of data file
		super();
		String[] split = line.split(",");
        this.firstName = split[0];
        this.lastName = split[1];
        Grade = Integer.parseInt(split[2]);
	}
	
	
	public StudentRecord(String firstName, String lastName, Integer grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Grade = grade;
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
		return Grade;
	}
	public void setGrade(Integer grade) {
		Grade = grade;
	}
	
	public String makeString( ) {		//Converts object into string for ease of printing
		return firstName + " " + lastName + ", Grade: " + Grade;
	}

}
