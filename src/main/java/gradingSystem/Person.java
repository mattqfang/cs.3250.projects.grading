package gradingSystem;

public class Person implements Comparable<Person>{
	private String first;
	private String last;
	private int score;
	
	Person(String first, String last, String score){
		this.first = first.trim().toLowerCase();
		this.last = last.trim().toLowerCase();
		this.score = Integer.parseInt(score.trim());
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String printPerson() {
		System.out.println(first + " " + last + " " + score);
		return first+" "+last+" "+score;
	}

	@Override
	public int compareTo(Person o) {
		if(this.score > o.score)
			return 1;
		else if(this.score < o.score)
			return -1;
		else
			return 0;
	}

}
