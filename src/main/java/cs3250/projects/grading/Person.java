package cs3250.projects.grading;

public class Person {
	
	String name;
	int grade;
	
	public Person(String n, int score) {
		name = n;
		grade = score;
	}
	
	public int GetGrade() {
		return grade;
	}
	
	public String GetNameLastFirst() {
		String[] names = name.split(" ");
		String newName = names[1] + ", " + names[0];
		
		return newName;
	}
}
