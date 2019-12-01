package cs3250.project.grading;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradingSystem {
    private static List<Person> students = new ArrayList<>();

    public void ReadStudents() {
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

    public static void main(String[] args) {
        GradingSystem test = new GradingSystem();
        test.ReadStudents();

        System.out.println("Students Read");
        for (Person s: students) {
            System.out.println(s.toString());
        }
    }
}