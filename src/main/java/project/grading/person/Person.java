package project.grading.person;

public class Person {
    private String first;
    private String last;
    private Integer grade;

    public Person() {
    }

    public Person(String first, String last, Integer grade) {
        this.first = first;
        this.last = last;
        this.grade = grade;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

    public Integer getGrade() {
        return this.grade;
    }

    public Person setFirst(String first) {
        this.first = first;
        return this;
    }

    public Person setLast(String last) {
        this.last = last;
        return this;
    }

    public Person setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return getLast().substring(0,1).toUpperCase() + getLast().substring(1).toLowerCase() // last
            + ", " + getFirst().substring(0,1).toUpperCase() + getFirst().substring(1).toLowerCase() // first
            + ": " + getGrade().toString();
    }

    public static Person createPerson(String line) {
        String[] data = line.trim().split(", *");
        return new Person(data[0], data[1], Integer.parseInt(data[2]));
    }
}