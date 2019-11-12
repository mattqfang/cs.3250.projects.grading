package cs3250.grading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grades {
	private String firstName;
	private String lastName;
	private int grade;

	public Grades() {
		
	}

	public static List<Grades> createList() {
		List<Grades> grades = new ArrayList<Grades>();
        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Jasen\\Desktop\\Java\\cs.3250.projects.grading\\src\\main\\resources\\data.txt")))
        {
            stream.forEach(p -> {
                String[] list = p.split(",");
                Grades grade = new Grades(list[0].trim(), list[1].trim(), list[2].trim());
                grades.add(grade);
            });
        }
        catch(IOException e) {

		}
		return grades;
	}

	public Grades(String first, String last, String grade) {
		this.firstName = first;
		this.lastName = last;
		this.grade = Integer.parseInt(grade);
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public static double findGradeByName(String firstName, String lastName, List<Grades> grades) {
        return grades.stream()
                     .filter(p -> p.getFirstName().equalsIgnoreCase(firstName) &&
                         p.getLastName().equalsIgnoreCase(lastName))
                     .findFirst()
                     .map(p -> p.getGrade())
                     .get();
    }

    public static double findMaxGrade(List<Grades> grades) {
        return grades.stream()
			   .sorted(Comparator.comparing(Grades::getGrade).reversed())
			   .map(p -> p.grade)
			   .findFirst()
			   .get();
    }

    public static double findAverageGrade(List<Grades> grades) {
        return grades.stream()
                     .mapToDouble(p -> p.getGrade())
					 .average()
					 .getAsDouble();
    }

    public static List<Grades> listPeopleByGrade(List<Grades> grades) {
        return (List<Grades>) grades.stream()
                     .sorted(Comparator.comparing(Grades::getGrade).reversed())
                     .collect(Collectors.toList());
                     
	}
}
	