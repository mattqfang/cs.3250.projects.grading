package uvu.cs.cs3250;

public class Person {
    
    String firstName;
    String lastName;
    int grade;
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getGrade() {
        return grade;
    }

	public void setFirstName(String input) {
		this.firstName = input;
		
	}
	
	public void setLastName(String input) {
		this.lastName = input;
		
	}
	
	public void setGrade(int parseInt) {
		this.grade = parseInt;
		
	}
    
}
