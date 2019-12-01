package cs3250.project.grading;

import java.io.*;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradingSystem {
    private static List<Person> students = new ArrayList<>();

    public GradingSystem() {
        String dataPath = new File("src/main/resources/data.txt").getAbsolutePath();

        try (Stream<String> entries = Files.lines(Paths.get(dataPath))) {
            students = entries.map(s -> {
                        String first = s.substring(0, s.indexOf(",")).trim();
                        String last = s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")).trim();
                        Integer grade = Integer.valueOf(s.substring(s.lastIndexOf(",") + 1).trim());

                        return new Person(first, last, grade);
                    }).collect(Collectors.toList());
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public String SearchStudent(String first, String last) {
        return Optional.ofNullable(students).orElseGet(Collections::emptyList).stream()
                .filter(s -> s.getFname().equalsIgnoreCase(first) && s.getLname().equalsIgnoreCase(last))
                .map(Person::toString)
                .findFirst().orElse(first + " " + last + " is not present in list");
    }

    public String getHighestGrade() {
        return Optional.ofNullable(students).orElseGet(Collections::emptyList).stream()
                .sorted((stu1, stu2) -> stu2.getGrade().compareTo(stu1.getGrade()))
                .map(Person::toString)
                .findFirst().orElse("Student list is empty...");
    }

    public Double getAverageGrade() {
        DecimalFormat df = new DecimalFormat("0.00");
        Double result = Optional.ofNullable(students).orElseGet(Collections::emptyList).stream()
                .mapToDouble(Person::getGrade)
                .average().orElse(999.99);

        return Double.parseDouble(df.format(result));
    }

    public List<Person> orderByGrade() {
        //Print Result
//        Optional.ofNullable(students).orElseGet(Collections::emptyList).stream()
//                .sorted((stu1, stu2) -> stu2.getGrade().compareTo(stu1.getGrade()))
//                .map(s -> new Person(s.getFname(), s.getLname(), s.getGrade()))
//                .forEach(System.out::println);

        //Return for testing
        return Optional.ofNullable(students).orElseGet(Collections::emptyList).stream()
                .sorted((stu1, stu2) -> stu2.getGrade().compareTo(stu1.getGrade()))
                .map(s -> new Person(s.getFname(), s.getLname(), s.getGrade())).collect(Collectors.toList());
    }

    public void printStudentList() {
        students.stream().forEach(System.out::println);
    }
}
