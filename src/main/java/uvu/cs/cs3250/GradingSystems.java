package uvu.cs.cs3250;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GradingSystems
{
    static List<Student> readFile() {
        List<Student> students = new ArrayList<>();

        // get the data from given resource file and parse line by third comma and map it
        try(Stream<String> stream = Files.lines(Paths.get("src/main/resources/data.txt")))
        {
            students = stream
                    .map(s -> {
                        String[] student = s.split(",");
                        return new Student(student[0].trim(), student[1].trim(), Integer.parseInt(student[2].trim()));
                    })
                    .collect(Collectors.toList());
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    // find the grade for a given person (first name and last name)
    static int findGradeByStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(s -> s.getFirstName().equalsIgnoreCase(firstName) && s.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .map(s -> s.getGrade())
                .get();
    }

    // find out the maximum grade with the name
    static String findStudentWithMaxGrade(List<Student> students) {
        int maxGrade = students.stream()
                .map(s -> s.getGrade())
                .max(Integer::compare)
                .get();

        return students.stream()
                .filter(s -> s.getGrade() == maxGrade)
                .findFirst()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .get();
    }

    // find out the average grade
    static double getAvgGrade(List<Student> students) {
        return students.stream()
                .mapToInt(s -> s.getGrade())
                .average()
                .getAsDouble();
    }

    // list all the persons (last name and first name) ordered by the grade
    static void listAllStudents(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(Student::getGrade))
                .forEach(System.out::println);

    }
}