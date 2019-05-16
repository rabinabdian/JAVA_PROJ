package performanceAndMonitoring.agent;

public class CourseFixed {

	private String title;
	private int hours;

	public CourseFixed(String title, int hours) {
		this.title = title;
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Course: " + title + " length in days " + (hours / 8);
	}

}
