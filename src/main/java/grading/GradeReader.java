package grading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class GradeReader {
	String path;

	GradeReader(String path) {
		this.path = path;
	}

	public int getGrade(String fName, String lName) throws IOException {
		// Return the grade of the person passed in. Return -1 if no such person is found.
		try {
			return parseGrade(
					Files.lines(Paths.get(path))
					.filter(x -> getFirst(x).equals(fName)
							&& getLast(x).equals(lName))
					.findFirst()
					.get());
		}
		catch (NoSuchElementException e) {}

		return -1;
	}

	public int maxGrade() throws IOException {
		try {
			return 	Files.lines(Paths.get(path))
					.mapToInt(GradeReader::parseGrade)
					.max()
					.getAsInt();
		}
		catch (NoSuchElementException e) {}
		
		// There is no element, so return -1
		return -1;
		
	}

	public double avgGrade() throws IOException {
		try {
			return Files.lines(Paths.get(path))
					.mapToInt(GradeReader::parseGrade)
					.average()
					.getAsDouble();
		}
		catch (NoSuchElementException e) {}
		
		// There is no element, so return -1
		return -1;
	}

	public void printAll() throws IOException {
		try {
			Files.lines(Paths.get(path))
				.sorted((String s1, String s2) -> {
					if (compareByGrade(s1, s2) != 0)
						return compareByGrade(s1, s2);
					if (compareByLastName(s1, s2) != 0)
						return compareByLastName(s1, s2);
					return compareByFirstName(s1, s2);
				})
				.forEach(GradeReader::printPerson);
		}
		catch (NoSuchElementException e) {}
	}

	private int compareByGrade(String s1, String s2) {
		int g1 = parseGrade(s1);
		int g2 = parseGrade(s2);
		
		if (g1 < g2)
			return -1;
		if (g1 > g2)
			return 1;
		return 0;
	}

	private int compareByLastName(String s1, String s2) {
		s1 = getLast(s1);
		s2 = getLast(s2);
		return s1.compareTo(s2);
	}

	private int compareByFirstName(String s1, String s2) {
		s1 = getFirst(s1);
		s2 = getFirst(s2);
		return s1.compareTo(s2);
	}

	private static void printPerson(String s) {
		System.out.printf("%-12s %-12s %-4d\n", getFirst(s), getLast(s), parseGrade(s));
	}

	private static String getFirst(String data) {
		return getItem(data, 0);
	}

	private static String getLast(String data) {
		return getItem(data, 1);
	}

	private static int parseGrade(String data) {
		return Integer.parseInt(getItem(data, 2));
	}

	private static String getItem(String data, int pos) {
		return data.split(",")[pos].strip();
	}
}
