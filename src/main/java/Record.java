public class Record {

  private String firstName;
  private String lastName;
  private Integer grade;

  Record (String firstName, String lastName, Integer grade) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.grade = grade;
  }

  Record (String fileRecord) {
    String[] attributes = fileRecord.replaceAll("\\s+", "").split(",");
    this.firstName = formatName(attributes[0]);
    this.lastName = formatName(attributes[1]);
    this.grade = Integer.parseInt(attributes[2]);
  }

  public void print() {
    System.out.println(lastName + ", " + firstName + ": " + grade + " points");
  }

  public String formatName(String name) {
    return name.substring(0,1).toUpperCase() 
         + name.substring(1).toLowerCase();
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public Integer getGrade() {
    return this.grade;
  }
}
