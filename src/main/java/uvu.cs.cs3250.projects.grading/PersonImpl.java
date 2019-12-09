package uvu.cs.cs3250.projects.grading;

import java.util.Comparator;

public class PersonImpl implements Person {
    private String firstName;
    private String lastName;
    private int grade;

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public int getGrade() {
        return grade;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return String.format(this.lastName + ", " + this.firstName + ", " + this.grade);
    }

    static public Comparator<Person> highToLowGrade = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            Integer num1 = o1.getGrade();
            Integer num2 = o2.getGrade();
            return num2.compareTo(num1);
        }
    };

    static public Comparator<Person> maxPersonComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            Integer num1 = o1.getGrade();
            Integer num2 = o2.getGrade();
            return num1.compareTo(num2);
        }
    };

}
