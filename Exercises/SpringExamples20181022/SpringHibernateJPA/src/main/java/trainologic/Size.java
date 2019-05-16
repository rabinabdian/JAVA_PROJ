package trainologic;

import javax.persistence.Embeddable;

@Embeddable
public class Size {
	private int width;
	private int height;

	public Size() {      // required no-args constructor
		
	}
	public Size( int width, int height) {
		this.height = height;
		this.width = width;
	}
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
}
