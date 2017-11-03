package Huangliangyun;

public class Circle1 implements Shape1 {
double r;
	public Circle1() {
		
	}
public Circle1(double r) {
		this.r=r;
	}

	@Override
	public double getArea() {
		
		return Math.PI*r*r;
	}

	@Override
	public void draw() {
		System.out.println("I am a circle,my area is:");

	}

}
