package uvu.cs.cs3250.assignments;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.*;
import java.util.stream.IntStream; 

public class Grading {
	public static void main(String[] args) {
		//System.out.println("test");
		String fileName = "src/main/resources/data.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			Get_Grade(Files.lines(Paths.get(fileName)), "Rudy", "conley");
			Get_Average(Files.lines(Paths.get(fileName)));
			Get_Max_Grade(Files.lines(Paths.get(fileName)));
			Get_Ordered_List(Files.lines(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void Get_Grade(Stream<String> var, String first, String Last) {
		System.out.println("The grade for Rudy is: ");
		System.out.println(var.map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.startsWith(first)).collect(Collectors.toList()));
	}
	public static void Get_Average(Stream<String> var) {
		System.out.println("The average grade is: ");
		Integer[] temp = var.map(s -> s.replace(",", " ")).map(s -> s.substring(s.lastIndexOf(" ")+1)).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
		IntStream stream = IntStream.of(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
		OptionalDouble obj = stream.average();
		System.out.println(obj.getAsDouble());
	}
	public static void Get_Max_Grade(Stream<String> var) {
		System.out.println("The max grade is: ");
		List<String> temp = var.collect(Collectors.toList());
		Integer[] list = temp.stream().map(s -> s.replace(",", " ")).map(s -> s.substring(s.lastIndexOf(" ")+1)).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
		List<Integer> arr = Arrays.asList(list);
		Integer max = arr.stream().max(Integer::compare).get(); 
		//System.out.println(max);
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(max.toString())).collect(Collectors.toList()));
		
	}
	public static void Get_Ordered_List(Stream<String> var) {
		System.out.println("The ordered grades are: ");
		List<String> temp = var.collect(Collectors.toList());
		Integer[] list = temp.stream().map(s -> s.replace(",", " ")).map(s -> s.substring(s.lastIndexOf(" ")+1)).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
		List<Integer> arr = Arrays.asList(list);
		Collections.sort(arr);
		
		System.out.println(arr.parallelStream().collect(Collectors.toList()));
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(list[5].toString())).collect(Collectors.toList()));
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(list[4].toString())).collect(Collectors.toList()));
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(list[3].toString())).collect(Collectors.toList()));
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(list[2].toString())).collect(Collectors.toList()));
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(list[1].toString())).collect(Collectors.toList()));
		System.out.println(temp.stream().map(s -> s.replace(" ", "")).map(s -> s.replace(",", " ")).filter(word -> word.endsWith(list[0].toString())).collect(Collectors.toList()));
		
		
	}
}
