package cs3250.project.grading;

public class Person {
    private String fname;
    private String lname;
    private Integer grade;

    public Person() {}

    public Person(String fname, String lname, Integer grade) {
        //Calls functions to format input to printable version
        this.setFname(fname);
        this.setLname(lname);
        this.grade = grade;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname.substring(0,1).toUpperCase() + fname.substring(1).toLowerCase();
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname.substring(0,1).toUpperCase() + lname.substring(1).toLowerCase();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return getLname() + ", " + getFname() + ": " + getGrade().toString();
    }
}
