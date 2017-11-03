package 练习测试;

public class 实验五Circle implements 实验五Shape {
double r;
	public 实验五Circle() {
	}

	public 实验五Circle(double r) {
		
		this.r = r;
	}

	public double getArea() {

		return Math.PI*r*r;
	}

	public void draw() {
		System.out.println("I am a 实验五Circle");
	}

}
