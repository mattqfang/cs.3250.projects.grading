package uvu.cs.cs3250.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public interface Grading {
	static String FindGrade(String firstName, String lastName) {
		List<String> file = null;
		
		try {
			file = Files.readAllLines(Paths.get("src/main/resources", "data.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String person = null;
		
		person = file.stream().filter(item -> item.contains(firstName)).findFirst().orElse(null);
		
		String[] finalPerson = person.replaceAll(" ", "").split(",");
			
		return finalPerson[2];
	}
	
	static String FindHighestGrade() {
		List<String> file = null;
		
		try {
			file = Files.readAllLines(Paths.get("src/main/resources", "data.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OptionalInt people = file.stream().mapToInt(item -> Integer.parseInt(item.replaceAll(" ","").split(",")[2])).max();
		
		Integer max = people.getAsInt();
		
		String person = file.stream().filter(item -> item.contains(max.toString())).findFirst().orElse(null);
		
		return person;
	}
}
