package cs3250.projects.grading;

public class Student {
    private String firstName;
    private String lastName;
    private int score;

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Student setScore(int score) {
        this.score = score;
        return this;
    }

    public Student(){
        super();
    }



} 
