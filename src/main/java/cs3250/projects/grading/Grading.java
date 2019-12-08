package cs3250.projects.grading;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Grading {
	
	List <Person> people = new ArrayList<Person>();
	
	public Grading() {
		// Get the data from the file.
		String fileName = "src/main/resources/data.txt";
	    List<String> lines = Collections.emptyList(); 
	    try { 
	      lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset()); 
	    } 
	  
	    catch (IOException e) { 
	      e.printStackTrace(); 
	    }
	    
	    lines.forEach(line -> {
	    	String[] elems = line.
	    			toLowerCase().
	    			replaceAll("[^a-z,0-9]", "").
	    			split(",");
	    	people.add(new Person(elems[0] + " " + elems[1], Integer.parseInt(elems[2])));
	    });
	}
	
	public int GetGradeFromName(String name) {
		return people.stream().
				filter(p -> p.name.equalsIgnoreCase(name)).
				findFirst().
				get().grade;
	}
	
	public String GetMaxGrade() {
		return people.stream().
				max(Comparator.comparingInt(Person::GetGrade)).
				get().name;
	}
	
	public double GetAverageGrade() {
		return people.stream().
				mapToDouble(Person::GetGrade).
				average().
				getAsDouble();
	}
	
	public void PrintSortedList() {
        List<Person> sortedList = people.stream().
        	sorted((f1, f2) -> Integer.compare(f2.GetGrade(), f1.GetGrade())).
        	collect(Collectors.toList());
        
        sortedList.forEach(item -> {
        	System.out.println(item.GetNameLastFirst());
        });
	}
}
