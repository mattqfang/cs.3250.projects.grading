import java.util.List;

public class Classroom {
	// Classroom is intended to hold multiple GradingSystem structures and operate on them.
	private List<GradingSystem> report;

	public List<GradingSystem> getReport() {
		return report;
	}

	public void setReport(List<GradingSystem> report) {
		this.report = report; 
	}
	
	// Organizational methods.
	public int findGradeByName(String first, String last) {
		return report.stream()
				.filter(p -> p.getLastName().equalsIgnoreCase(last))
				.filter(p -> p.getFirstName().equalsIgnoreCase(first))
				.findAny()
				.orElse(null)
				.getGrade();
	}
	
	public String nameOfMaxGrade() {
		int topGrade = report.stream()
				.map(p -> p.getGrade())
				.max(Integer::compare)
				.get();
		return report.stream()
				.filter(p -> p.getGrade() == topGrade)
				.findAny()
				.orElse(null)
				.getName();
	}
	
	public int avgGrade() {
		return (int) report.stream()
				.mapToInt(p -> p.getGrade())
				.average()
				.orElse(0);
	}
	
	public String listNames() {
		return report.stream()			// create stream of report
				.sorted((x, y) -> x.getGradeInteger().compareTo(y.getGradeInteger()))	// sort the stream into ordered form.
				.map(m -> m.getName())
				.toString();
	}
	
}
