package GradingProject;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;

public class Classroom {
	// Classroom is intended to hold multiple GradingSystem structures and operate on them.
	private List<GradingSystem> report;
	public int readFilefromInput(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\Z");
		String buffer = scanner.next();
		System.out.println(buffer);
		scanner.close();
		List<String> bufList = buffer.trim()
				.replace(",", "\n")
				.replaceAll(" ", "")
				.lines()
				.collect(Collectors.toList());
		bufList.forEach(p -> System.out.println(p));
		bufList.stream()
			.peek(p -> {
				GradingSystem tempGradeSystem = new GradingSystem();
				tempGradeSystem.setFirstName(p);
				tempGradeSystem.setLastName(p+1);
				tempGradeSystem.setGrade(p+2);
				report.add(tempGradeSystem);
				}
			);
		/*String[] bufArray = bufList.toArray(new String[0]);
		// Sorry, ran out of time to figure this part out without a loop..
		for (int i = 0; i < bufList.size(); ++i) {
			GradingSystem tempGradeSystem = new GradingSystem();
			tempGradeSystem.setFirstName(bufArray[i]);
			tempGradeSystem.setLastName(bufArray[++i]);
			tempGradeSystem.setGrade(bufArray[++i]);
			report.add(tempGradeSystem); // For some reason this is a null pointer. I could not figure out why. 
		} */
		listNames();
		return 0;
	}
	public List<GradingSystem> getReport() {
		return report;
	}

	public void setReport(List<GradingSystem> report) {
		this.report = report; 
	}
	
	// Organizational methods.
	public int findGradeByName(String first, String last) {
		return report.stream()
				.filter(p -> p.getLastName().equalsIgnoreCase(last))
				.filter(p -> p.getFirstName().equalsIgnoreCase(first))
				.findAny()
				.orElse(null)
				.getGrade();
	}
	
	public String nameOfMaxGrade() {
		int topGrade = report.stream()
				.map(p -> p.getGrade())
				.max(Integer::compare)
				.get();
		return report.stream()
				.filter(p -> p.getGrade() == topGrade)
				.findAny()
				.orElse(null)
				.getName();
	}
	
	public int avgGrade() {
		return (int) report.stream()
				.mapToInt(p -> p.getGrade())
				.average()
				.orElse(0);
	}
	
	public String listNames() {
		return report.stream()			// create stream of report
				.sorted((x, y) -> x.getGradeInteger().compareTo(y.getGradeInteger()))	// sort the stream into ordered form.
				.map(m -> m.getName())
				.toString();
	}
	
}
