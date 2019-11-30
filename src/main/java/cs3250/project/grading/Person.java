package cs3250.project.grading;

public class Person {
    private String fname;
    private String lname;
    private Integer grade;

    public Person() {}

    public Person(String fname, String lname, Integer grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
