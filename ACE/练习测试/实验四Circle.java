package ��ϰ����;

/**
 * @author hly
 *
 */
public class ʵ����Circle extends ʵ����Shape {
double r;
	public ʵ����Circle() {
	}
	

	public ʵ����Circle(double r) {
		
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
