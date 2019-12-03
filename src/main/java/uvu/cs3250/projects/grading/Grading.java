package uvu.cs3250.projects.grading;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Grading {

    public static void main(String[] args){
        Grading.setupGrades();
        System.out.println("This main function runs through the execution of the requirements given on canvas.\n");
        System.out.println("Requirement 1: Find the grade for a given person:");
        System.out.println("Dante Exum's grade can be found with getGradeByName(\"dante\",\"exum\"). Result = "+getGradeByName("dante","exum"));
        System.out.println("Rudy Gobert's grade can be found with getGradeByName(\"rudy\",\"gobert\"). Result = "+getGradeByName("rudy","gobert")+"\n");
        System.out.println("Requirement 2: Find the maximum grade with its associated name:");
        System.out.println("Max Grade can be found with getMaxGradeWithName(), and returns an IndividualGrade object. The highest grade is "+getMaxGradeWithName().getGrade()+", and it belongs to "+getMaxGradeWithName().getFullName()+"\n");
        System.out.println("Requirement 3: Find the average grade:");
        System.out.println("This can be done with getAverageGrade(). Result = "+getAverageGrade()+"\n");
        System.out.println("Requirement 4: List all persons ordered by grade:");
        System.out.println("This can be done with the printAllGradesOrdered() function. Results are below:");
        printAllGradesOrdered();
    }

    public static class IndividualGrade{
        private String firstName;
        private String lastName;
        private Integer grade;

        IndividualGrade(String firstName, String lastName, Integer grade){
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() { return firstName; }

        public String getLastName() { return lastName; }

        public String getFullName() { return firstName + " " + lastName; }

        public Integer getGrade() { return grade; }
    }

    private static List<IndividualGrade> gradesList;

    public static void setupGrades(){
        List<String> inputFile = null;
        try {
            inputFile = Files.readAllLines(Paths.get("src/main/resources", "data.txt"));
            gradesList = new ArrayList<>();
            for(String line : inputFile){
                String[] words = line.replaceAll(" ","").split(",");
                if(words.length == 3){
                    gradesList.add(new IndividualGrade(words[0],words[1], Integer.parseInt(words[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getGradeByName(String first, String last){
        return gradesList.stream()
                .filter(ind -> ind.getFirstName().equalsIgnoreCase(first))
                .filter(ind -> ind.getLastName().equalsIgnoreCase(last))
                .findFirst().get().getGrade();
    }

    public static IndividualGrade getMaxGradeWithName(){
        return gradesList.stream()
                .sorted(Comparator.comparing(IndividualGrade::getGrade).reversed())
                .findFirst()
                .get();
    }

    public static double getAverageGrade(){
        return gradesList.stream()
                .map(ind -> ind.getGrade())
                .collect(Collectors.averagingInt(num -> Integer.valueOf((Integer) num)));
    }

    public static List<IndividualGrade> getAllGradesOrdered(){
        return gradesList.stream()
                .sorted(Comparator.comparing(ind -> ind.getGrade()))
                .collect(Collectors.toList());
    }

    public static void printAllGradesOrdered(){
        getAllGradesOrdered().stream()
                .forEach(grade -> System.out.println(grade.getLastName()+", "+grade.getFirstName()));
    }
}
