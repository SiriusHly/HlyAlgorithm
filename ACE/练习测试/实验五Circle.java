package ��ϰ����;

public class ʵ����Circle implements ʵ����Shape {
double r;
	public ʵ����Circle() {
	}

	public ʵ����Circle(double r) {
		
		this.r = r;
	}

	public double getArea() {

		return Math.PI*r*r;
	}

	public void draw() {
		System.out.println("I am a ʵ����Circle");
	}

}
