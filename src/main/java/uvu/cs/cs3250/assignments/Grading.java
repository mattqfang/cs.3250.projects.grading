package uvu.cs.cs3250.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public interface Grading {
	static String FindGrade(String firstName, String lastName) {
		List<String> file = null;
		
		try {
			file = Files.readAllLines(Paths.get("src/main/resources", "data.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String person = file.stream().filter(item -> item.contains(firstName)).findFirst().orElse(null);
		
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
		
		OptionalInt maxGrade = file.stream().mapToInt(item -> Integer.parseInt(item.replaceAll(" ","").split(",")[2])).max();
		
		Integer max = maxGrade.getAsInt();
		
		String person = file.stream().filter(item -> item.contains(max.toString())).findFirst().orElse(null);
		
		return person;
	}
	
	static int FindAvgGrade() {
		List<String> file = null;
		
		try {
			file = Files.readAllLines(Paths.get("src/main/resources", "data.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] avgGrade = file.stream().mapToInt(item -> Integer.parseInt(item.replaceAll(" ", "").split(",")[2])).toArray();
		
		int average = (int)Arrays.stream(avgGrade).average().getAsDouble();
		
		return average;
	}
	
	static void ListAll() {
		List<String> file = null;
		
		try {
			file = Files.readAllLines(Paths.get("src/main/resources", "data.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> sorted = file.stream().sorted(Comparator.comparing(item -> Integer.parseInt(item.toString().replaceAll(" ", "").split(",")[2])).reversed()).collect(Collectors.toList());
		
		System.out.println(sorted);
	}
}
