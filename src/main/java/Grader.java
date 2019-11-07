import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import java.io.IOException;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Grader {
  private List<Record> records = new ArrayList<Record>();
  String recordFile = "src/main/resources/data.txt";

  Grader() {
    readRecordsFromFile(recordFile);
  }

  Grader(String path) {
    readRecordsFromFile(path);
  }

  public Integer getNumRecords() {
    return records.size();
  }

  public Integer getGrade(String firstName, String lastName) {
    return records.stream()
      .filter( r -> r.getFirstName().equalsIgnoreCase(firstName) )
      .filter( r -> r.getLastName().equalsIgnoreCase(lastName) )
      .findFirst()
      .map(record -> record.getGrade())
      .get();
  }

  public String getNameOfTopScore() {
    return records.stream()
      .sorted((lhs, rhs) -> rhs.getGrade().compareTo(lhs.getGrade()))
      .findFirst()
      .map(r -> { return r.getFirstName() + " " + r.getLastName(); })
      .get();
  }

  public Double getAverageGrade() {
    return records.stream()
      .mapToInt(r -> r.getGrade())
      .average()
      .getAsDouble();
  }

  public List<String> listRecordsByGrade() {
    return records.stream()
      .sorted((lhs, rhs) -> rhs.getGrade().compareTo(lhs.getGrade()))
      .map(r -> { return r.getFirstName() + " " + r.getLastName(); })
      .collect(Collectors.toList());
  }

  private void readRecordsFromFile(String dir) {
    File f = new File(dir);
    String fullPath = f.getAbsolutePath();

    try (Stream<String> stream = Files.lines(Paths.get(fullPath))) {
      stream.forEach(line -> records.add(new Record(line)));
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
