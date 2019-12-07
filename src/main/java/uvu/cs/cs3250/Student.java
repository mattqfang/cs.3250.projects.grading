package uvu.cs.cs3250;

public class Student
{
    private String firstname;
    private String lastname;
    private int grade;

    // getters
    String getFirstName() {
        return this.firstname;
    }
    String getLastName() {
        return this.lastname;
    }
    int getGrade() {
        return this.grade;
    }

    // setters
    private void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    private void setLastName(String lastname) {
        this.lastname = lastname;
    }
    private void setGrade(int grade) {
        this.grade = grade;
    }

    Student(String firstName, String lastName, int grade)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGrade(grade);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.firstname + " " + this.lastname + " (" + this.grade + ")";
    }
}