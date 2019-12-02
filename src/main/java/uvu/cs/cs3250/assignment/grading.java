package uvu.cs.cs3250.assignment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class person implements Comparable<person> {
	String first;
	String last;
	Integer grade;
	
	public person(String first, String last, int grade) {
        this.first = first;
        this.last = last;
        this.grade = grade;
    }
	public person(String first, String last, String strGrade) {
        this.first = first;
        this.last = last;
        strGrade = strGrade.replaceAll("\\s","");
        
        this.grade = Integer.parseInt(strGrade);
    }
	public Integer getGrade() {
		return grade;
	}
	public String getFirstName() {
		return first;
	}
	public String getLastName() {
		return last;
	}
    @Override
    public int compareTo(person o) {
        return this.getGrade().compareTo(o.getGrade());
    }
    @Override
    public String toString() {
    	String result = getFirstName()+" " + getLastName() + " " + getGrade();
        return result;
    }
	
}

public class grading{
	
	public static Integer getGrade(String firstName, String lastName) {
		
		InputStream input = grading.class.getResourceAsStream("data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = null;
		ArrayList<person> persons = new ArrayList<>();
		try {
			while((line = br.readLine()) != null) {
				line = line.toLowerCase();
				String[] splits = line.split(",",3 );
				
				person newGuy = new person(splits[0], splits[1], splits[2]);
				persons.add(newGuy);
				//System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		person target = persons.stream().filter(person -> firstName.equalsIgnoreCase(person.getFirstName())).findAny().orElse(null);
		return target.getGrade();
//		return 0;
	}

	public static String getMaxGrade() {
		InputStream input = grading.class.getResourceAsStream("data.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = null;
		ArrayList<person> persons = new ArrayList<>();
		try {
			while((line = br.readLine()) != null) {
				line = line.toLowerCase();
				String[] splits = line.split(",",3 );
				
				person newGuy = new person(splits[0], splits[1], splits[2]);
				persons.add(newGuy);
				//System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(persons, Collections.reverseOrder());
		line = null;
		person target = persons.get(0);
		line = target.getFirstName() + target.getLastName() + " " + Integer.toString(target.getGrade());
		return line;
		
		
	}
	public static void showOrderedGrades() {
		InputStream input = grading.class.getResourceAsStream("data.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = null;
		ArrayList<person> persons = new ArrayList<>();
		try {
			while((line = br.readLine()) != null) {
				line = line.toLowerCase();
				String[] splits = line.split(",",3 );
				
				person newGuy = new person(splits[0], splits[1], splits[2]);
				persons.add(newGuy);
				//System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(persons, Collections.reverseOrder());
		persons.forEach(System.out::println);
		
		
		
	}

public static double getAverageGrade() {
	InputStream input = grading.class.getResourceAsStream("data.txt");
	
	BufferedReader br = new BufferedReader(new InputStreamReader(input));
	String line = null;
	int count = 0;
	int sum = 0;
	double total = 0;
//	ArrayList<person> persons = new ArrayList<>();
	try {
		while((line = br.readLine()) != null) {
			line = line.toLowerCase();
			String[] splits = line.split(",",3 );
			String data = splits[2];
			data = data.replaceAll("\\s","");
			int val = Integer.parseInt(data);
			sum +=val;
			count += 1;
			
//			person newGuy = new person(splits[0], splits[1], splits[2]);
//			persons.add(newGuy);
			//System.out.println(line);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	total = sum;
	total = total/count;
	return total;
	
	
	
}
}

