import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.nio.file.*;

//Grading class.
//No use of "loops" or "if's"
class Grading{
	public static void main(String[] args) {
		;
	}
	
	//Find Grade Function
	public int FindGrade(String firstName, String lastName) throws FileNotFoundException
	{
		int studentGrade = 0;
		
		//Use in all functions
		File table = new File("src/main/resources/data.txt");
		Scanner scan = new Scanner(table);
		scan.findWithinHorizon(firstName,1000);
		scan.findWithinHorizon(lastName, 1000);
		scan.skip(",");
		studentGrade = scan.nextInt();
		scan.close();
		return studentGrade;
	}
	
	//Find Max Grade Function
	public int FindMaxGrade() throws Exception
	{
		String fileData = ""; 
		int max = 0;
		fileData = new String(Files.readAllBytes(Paths.get("src/main/resources/data.txt"))); 
		String[] stringArray = new String[6];
		stringArray = fileData.split("\r");
		
		stringArray[0] = stringArray[0].substring(stringArray[0].length()-2);
		stringArray[1] = stringArray[1].substring(stringArray[1].length()-2);
		stringArray[2] = stringArray[2].substring(stringArray[2].length()-2);
		stringArray[3] = stringArray[3].substring(stringArray[3].length()-2);
		stringArray[4] = stringArray[4].substring(stringArray[4].length()-2);
		stringArray[5] = stringArray[5].substring(stringArray[5].length()-2);
		stringArray[0] = stringArray[0].replace(",", "");
		stringArray[1] = stringArray[1].replace(",", "");
		stringArray[2] = stringArray[2].replace(",", "");
		stringArray[3] = stringArray[3].replace(",", "");
		stringArray[4] = stringArray[4].replace(",", "");
		stringArray[5] = stringArray[5].replace(",", "");
		
		int[] intArray = new int[6];
		intArray[0] = Integer.parseInt(stringArray[0]);
		intArray[1] = Integer.parseInt(stringArray[1]);
		intArray[2] = Integer.parseInt(stringArray[2]);
		intArray[3] = Integer.parseInt(stringArray[3]);
		intArray[4] = Integer.parseInt(stringArray[4]);
		intArray[5] = Integer.parseInt(stringArray[5]);
	
		List<Integer> intList = Arrays.asList(intArray[0], intArray[1], intArray[2], intArray[3], intArray[4], intArray[5]);
		max = intList.stream()
				.max(Comparator.comparing(Integer::valueOf))
				.get();
		
		return max;
	}
	
	//Find Average Grade Function
	public double FindAverageGrade() throws Exception
	{
		String fileData = ""; 
		fileData = new String(Files.readAllBytes(Paths.get("src/main/resources/data.txt"))); 
		String[] stringArray = new String[6];
		stringArray = fileData.split("\r");
		
		stringArray[0] = stringArray[0].substring(stringArray[0].length()-2);
		stringArray[1] = stringArray[1].substring(stringArray[1].length()-2);
		stringArray[2] = stringArray[2].substring(stringArray[2].length()-2);
		stringArray[3] = stringArray[3].substring(stringArray[3].length()-2);
		stringArray[4] = stringArray[4].substring(stringArray[4].length()-2);
		stringArray[5] = stringArray[5].substring(stringArray[5].length()-2);
		stringArray[0] = stringArray[0].replace(",", "");
		stringArray[1] = stringArray[1].replace(",", "");
		stringArray[2] = stringArray[2].replace(",", "");
		stringArray[3] = stringArray[3].replace(",", "");
		stringArray[4] = stringArray[4].replace(",", "");
		stringArray[5] = stringArray[5].replace(",", "");
		
		int[] intArray = new int[6];
		intArray[0] = Integer.parseInt(stringArray[0]);
		intArray[1] = Integer.parseInt(stringArray[1]);
		intArray[2] = Integer.parseInt(stringArray[2]);
		intArray[3] = Integer.parseInt(stringArray[3]);
		intArray[4] = Integer.parseInt(stringArray[4]);
		intArray[5] = Integer.parseInt(stringArray[5]);
		
		List<Integer> intList = Arrays.asList(intArray[0], intArray[1], intArray[2], intArray[3], intArray[4], intArray[5]);
		
		OptionalDouble averageValue = intList.stream().mapToDouble(a -> a).average();

		System.out.println(averageValue.isPresent() ? averageValue.getAsDouble() : 0);
		
		return averageValue.isPresent() ? averageValue.getAsDouble() : 0;
	}
	
	//List all people ordered
	public String OrderByGrade() throws Exception
	{
		
		File table = new File("src/main/resources/data.txt");
		Scanner scan = new Scanner(table);
		String intermediate = scan.toString();
		String result;
		String[] stringArray = new String[6];
		stringArray = intermediate.split("\n");
		Arrays.parallelSort(stringArray);
		result = Arrays.deepToString(stringArray);
		scan.close();
		return result;
	}
}
