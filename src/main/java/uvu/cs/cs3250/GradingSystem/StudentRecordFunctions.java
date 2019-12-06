package uvu.cs.cs3250.GradingSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class StudentRecordFunctions {

	public Integer findGrade(String firstName, String lastName, ArrayList<StudentRecord> records) {		//takes in first and last name and returns grade
		return records.stream()
				.filter(p -> p.getFirstName().equalsIgnoreCase(firstName) &&
							p.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.map(p -> p.getGrade())
				.orElse(0);
	}
	
	public String highestGrade(ArrayList<StudentRecord> records) {		//returns highest grade in the ArrayList
		return records.stream()
				.max(Comparator.comparing(StudentRecord::getGrade))
				.map(p -> p.makeString())
				.get();
	}
	
	public double averageGrade(ArrayList<StudentRecord> records) {		//returns the average of the grades in the student records
		return records.stream()
					.mapToInt(p -> p.getGrade())
					.average()
					.getAsDouble();
		
	}
	
	public void orderByGrade(ArrayList<StudentRecord> records) {		//orders and prints out the student records based on grades
		 records.stream()
				.sorted(Comparator.comparing(StudentRecord::getGrade))
				.map(p -> p.makeString())
				.forEach(System.out::println);
	}
	
	public ArrayList<StudentRecord> createRecordList(String fileName) {		//parses data file and makes arraylist of objects of StudentRecord
		ArrayList<StudentRecord> records = new ArrayList<StudentRecord>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream
				.map(s -> s.replaceAll("\\s", ""))
				.forEach(r -> records.add(new StudentRecord(r)));
		} catch(IOException e) {
			System.out.println("Unable to access file.");
		}
		return records;
	}
}
