package cs3250.project.grading;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradingSystem {
    private static List<Person> students = new ArrayList<Person>();

    public void ReadStudents() {
        String dataPath = new File("src/main/java/resources/data.txt").getAbsolutePath();
        try {
            Stream<String> entries = Files.lines(Paths.get(dataPath));
            students = entries.map(s -> {
                String fName = s.substring(0, s.indexOf(","));
                String lName = s.substring(s.indexOf(","), s.lastIndexOf(","));
                Integer grade = Integer.valueOf(s.substring(s.lastIndexOf(",") + 1));

                return new Person(fName, lName, grade);
            }).collect(Collectors.toList());
        }
        catch(IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        GradingSystem test = new GradingSystem();
        test.ReadStudents();

        System.out.println("Students Read");
    }
}
