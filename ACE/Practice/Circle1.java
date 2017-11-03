package Practice;

public class Circle1 implements Shape {
double r;
	public  Circle1(double r){
		this.r=r;
	}
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 3.14*r*r;
	}

}
