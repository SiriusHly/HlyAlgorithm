package FuXi5;

public class Circle0 implements Shape {
double r;
	public Circle0(double r) {
		this.r=r;
	}

	@Override
	public double getArea() {
		
		return Math.PI*r*r;
	}

	@Override
	public void draw() {
		System.out.println("I am a ÊµÑéËÄCircle");
	}

	public static void main(String[] args) {

	}

}

class TestInterface{
	
	public static void main(String[]a){
		Circle0 p1 = new Circle0(3);
		System.out.println(p1.getArea());
		p1.draw();
	}
}
