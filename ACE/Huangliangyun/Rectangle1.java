package Huangliangyun;

public class Rectangle1 implements Shape1 {
double length,width;
	public Rectangle1() {
		
	}
public Rectangle1(double length,double width) {
		this.length=length;
		this.width=width;
	}

	@Override
	public double getArea() {
		
		return length*width;
	}

	@Override
	public void draw() {
		System.out.println("I am a rectangle£¬my area is:");

	}

}
