import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class grading {
    public List<Profile> gradeList = new ArrayList<Profile>();


    public void readGrades() {
        try {
            Stream<String> grades = Files.lines(Paths.get("src/main/resources/", "data.txt"));
            grades
                .map(item -> item.toLowerCase().replaceAll(" ", "").split(","))
                .map(item -> new Profile(item[0], item[1], Integer.parseInt(item[2])))
                .forEach(item -> gradeList.add(item));
            grades.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public Integer findGrade(String firstName, String lastName) {
        return gradeList.stream()
            .filter(user -> user.first.equals(firstName))
            .filter(user -> user.last.equals(lastName))
            .map(user -> user.grade)
            .findFirst()
            .get();
    }
    public String findHighestGrade() {
        return gradeList.stream()
        .sorted((a , b) -> b.grade - a.grade)
        .map(user -> {
            return user.first + " " + user.last;}
            )
        .findFirst()
        .get();
    }
    public Double averageGrade(){
        return gradeList.stream()
        .mapToInt(user -> user.grade)
        .average()
        .getAsDouble();

    }
    public List<String> listByGrade() {
        return gradeList.stream()
        .sorted((a , b) -> b.grade - a.grade)
        .map(user -> {
            return user.first + " " + user.last;}
            )
        .collect(Collectors.toList());
    }
    

}