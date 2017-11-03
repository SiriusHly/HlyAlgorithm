package 练习测试;

public class 实验四Rectangle extends 实验四Shape {
double width,heigh;
	public 实验四Rectangle() {
	}

	public 实验四Rectangle(double width, double heigh) {
		
		this.width = width;
		this.heigh = heigh;
	}


	@Override
	public double getArea() {
		return width*heigh;
	}

	@Override
	public double getPerimeter() {
		return 2*width*heigh;
	}

}
