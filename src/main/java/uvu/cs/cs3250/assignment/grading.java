package uvu.cs.cs3250.assignment;

import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class grading{
//	public static String getGrade(String firstName, String lastName) {
//		String file = "/GradingSystem/src/main/resources/data.txt";
//		List<String> list = new ArrayList<>();
//		try (Stream<String> stream = Files.lines(Paths.get(file))){
//			list = stream.filter()
//			
//			
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	public static String getMaxGrade(String name) {
//		
//	}
//	public static Integer getAverageGrade() {
//		
//	}
	public static void showOrderedGrades() {
		
		//Properties properties = new Properties();
		InputStream input = grading.class.getResourceAsStream("data.txt");
		
		
	}
}