package 练习测试;

public class 实验五Rectangle implements 实验五Shape {
double width,heigh;

	public 实验五Rectangle() {
	}

	public 实验五Rectangle(double width, double heigh) {
		super();
		this.width = width;
		this.heigh = heigh;
	}

	@Override
	public double getArea() {

		return width*heigh;
	}

	@Override
	public void draw() {
		System.out.println("I am a 实验五Rectangle");
	}

}
