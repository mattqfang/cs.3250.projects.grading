import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Student {
	private String first_name;
	private String last_name;
	private Double grade;

	public Student (String first_name, String last_name, Double grade) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.grade = grade;
	}

	public Student (String entry) {
		super();
		// System.out.println(entry);
		List<String> columns = Arrays.asList(entry.split(",", 0));
		columns = columns.stream()
			.map(s -> {
				// Remove whitespace and capitalize names correctly
				s = s.replaceAll("\\s", "").toLowerCase();
				return s.substring(0, 1).toUpperCase() + s.substring(1);
			})
			.collect(Collectors.toList());

		this.first_name = columns.get(0);
		this.last_name = columns.get(1);
		this.grade = Double.parseDouble(columns.get(2));
		// System.out.println(first_name);
		// System.out.println(last_name);
		// System.out.println(grade);
	}

	public void setFirstName (String first_name) {
		this.first_name = first_name;
	}

	public String getFirstName () {
	   return this.first_name;
	}

	public void setLastName (String last_name) {
		this.last_name = last_name;
	}

	public String getLastName () {
	   return this.last_name;
	}

	public void setGrade (Double grade) {
		this.grade = grade;
	}

	public Double getGrade () {
	   return this.grade;
	}

	public String getFullName () {
		return this.first_name + ' ' + this.last_name;
	}

	public String getFullRecord () {
		return this.first_name + ' ' + this.last_name + " (" + this.grade + ")";
	}
}
