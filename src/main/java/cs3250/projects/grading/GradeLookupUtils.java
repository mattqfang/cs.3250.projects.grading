package cs3250.projects.grading;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface GradeLookupUtils {

    static Integer getGradeByName(String firstName, String lastName, List<Student> db) {
        return db.stream()
                .filter(s -> firstName.equalsIgnoreCase(s.getFirstName()))
                .filter(s -> lastName.equalsIgnoreCase(s.getLastName()))
                .findFirst()
                .map(Student::getScore)
                .orElse(null);
    }

    static String getMaxGradeWithName(List<Student> db) {
        return db.stream()
                .max(Comparator.comparing(Student::getScore))
                .map(s -> s.getFirstName() + " " + s.getLastName() + ": " + s.getScore())
                .orElse(null);
    }

    static Double getAverageGrade(List<Student> db) {
        return db.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(-1.0);
    }

    static List<String> getStudentsOrderedByGrade(List<Student> db) {
        return db.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.toList());
    }
} 
