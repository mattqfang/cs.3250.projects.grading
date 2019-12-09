package uvu.cs.cs3250.projects.grading;

public interface PersonFactory {
    static Person getInstance() {
        return new PersonImpl();
    }
    static Person getInstance(String firstName, String lastName, int grade) {
        Person person = getInstance();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setGrade(grade);

        return person;
    }
}
