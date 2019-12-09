package uvu.cs.cs3250.projects.grading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static uvu.cs.cs3250.projects.grading.PersonFactory.getInstance;
import static uvu.cs.cs3250.projects.grading.PersonImpl.highToLowGrade;
import static uvu.cs.cs3250.projects.grading.PersonImpl.maxPersonComparator;


public class Grading {

    private static List<Person> openFileWithStudents(String filePath) {
        Path file = Paths.get(filePath);
        List<Person> students = new ArrayList<>();

        try(Stream<String> lines = Files.lines(file)) {
            students = lines
                    .map(p -> {
                        String firstName = p.substring(0, p.indexOf(",")).trim();
                        String lastName = p.substring(p.indexOf(",") + 1, p.lastIndexOf(",")).trim();
                        int grade = Integer.parseInt(p.substring(p.lastIndexOf(",") + 1).trim());
                        return getInstance(firstName, lastName, grade);
                    }).collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    static public int getStudentGrade(String firstName, String lastName, String filePath) {
        List<Person> students = openFileWithStudents(filePath);
        return students.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(firstName) &&
                        p.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .map(Person::getGrade)
                .orElseGet(() -> {
                    System.out.println("Person cannot be found!");
                    return 0;
                });
    }

    static public String getMaxGrade(String filePath) {
        List<Person> students = openFileWithStudents(filePath);

        return students.stream()
                .max(maxPersonComparator)
                .get()
                .toString();
    }

    static public int getAverageGrade(String filePath) {
        List<Person> students = openFileWithStudents(filePath);
        int sumOfGrades = students.stream()
                .mapToInt(Person::getGrade)
                .reduce(0, Integer::sum);
        double roundedAverage = Math.round((double) sumOfGrades / students.size());
        return (int) roundedAverage;
    }

    static public String printStudentsByHighGrade (String filePath) {
        List<Person> students = openFileWithStudents(filePath);

        return students.stream()
                .sorted(highToLowGrade)
                .map(p -> {
                    System.out.println(p.toString());
                    return p.toString();
                })
                .collect(Collectors.joining("\n"));
    }
}
