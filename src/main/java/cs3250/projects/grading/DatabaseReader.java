package cs3250.projects.grading;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseReader {

    private List<Student> students;

    public DatabaseReader(String fileName) {
        students = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            students = lines
                    .map(line -> {
                        String[] strings = line.split(",");
                        return new Student()
                                .setFirstName(strings[0].trim())
                                .setLastName(strings[1].trim())
                                .setScore(Integer.parseInt(strings[2].trim()));
                    })
                    .collect(Collectors.toList());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }


} 
