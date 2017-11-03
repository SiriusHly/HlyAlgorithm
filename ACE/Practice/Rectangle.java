package Practice;

public class Rectangle implements Shape {
double w,h;
public Rectangle(double w,double h){
	this.w=w;
	this.h=h;
}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return w*h;
	}

}
