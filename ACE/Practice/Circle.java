package Practice;

public class Circle implements Shape {
 private int r;
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public Circle(int r){
		this.r=r;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 3.14*r*r;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

}
