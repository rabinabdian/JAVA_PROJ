package performanceAndMonitoring.agent;

public class Course {

	private String title;
	private int hours;

	public Course(String title, int hours) {
		this.title = title;
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Course: " + title + " length in days " + (hours / 10);
	}

}
