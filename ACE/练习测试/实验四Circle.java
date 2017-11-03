package 练习测试;

/**
 * @author hly
 *
 */
public class 实验四Circle extends 实验四Shape {
double r;
	public 实验四Circle() {
	}
	

	public 实验四Circle(double r) {
		
		this.r = r;
	}


	@Override
	public double getArea() {
		return Math.PI*r*r;
	}

	@Override
	public double getPerimeter() {
		return 2*Math.PI*r;
	}

}
