/*
The repo url for this project: https://github.com/mattqfang/cs.3250.projects.grading.git (Links to an external site.)
There is a data file located at src/main/resources. This file contains the data needed for this project. 
Each line of the  file contains 3 columns: first name, last name, grade.

In this project you need to implement the following functions:

1. find the grade for a given person (first name and last name)

2. find out the maximum grade with the name

3. find out the average grade.

4. list all the persons (last name and first name) ordered by the grade

No "loop" or "if" structures  are allowed in this project.
*/

package project.grading.grading;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import project.grading.person.Person;

public class GradingSystem {
    private List<Person> personList;
    private File file;

    public GradingSystem setPersonList(List<Person> personList) {
        this.personList = personList;
        return this;
    }

    public GradingSystem setFile(File file) {
        this.file = file;
        return this;
    }

    public List<Person> getPeople() {
        return personList;
    }

    public String getFilePath() {
        return file.getName();
    }

    public Boolean createPersonList() {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            this.personList = stream.map(l -> Person.createPerson(l)).collect(Collectors.toList());
            return true;
        } catch (final IOException e) {
            System.out.println("GradingSystem.createList(): " + e);
            return false;
        }
    }

    public void printPersonList() {
        getPeople().stream().forEach(System.out::println);
    }

    public Integer getGradeByName(String first, String last) {
        return personList.stream()
            .filter(p -> first.equalsIgnoreCase(p.getFirst()) && last.equalsIgnoreCase(p.getLast()))
            .map(Person::getGrade)
            .findAny()
            .orElseGet(null);
    }

    public String getPersonWithMaximumGrade() {
        return personList.stream()
            .sorted(Comparator.comparing(Person::getGrade).reversed())
            .findFirst()
            .orElseGet(null)
            .toString();
    }    
    
    public BigDecimal getAverageGrade() {
        Double sum = (double) personList.stream().mapToLong(Person::getGrade).sum();
        Double count = (double) personList.stream().count();
        return new BigDecimal(sum/count).setScale(2,RoundingMode.HALF_UP);
    }

    public String orderByGrade() {
        return personList.stream()
            .sorted(Comparator.comparing(Person::getGrade))
            .collect(Collectors.toList())
            .toString();
    }
}