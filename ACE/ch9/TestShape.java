package ch9;

public class TestShape {

	public TestShape() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape c1=new Circle(3);
		Shape c2=new Rectangle(3,4);
		System.out.println("c1.getArea()="+c1.getArea());
		System.out.println("c2.getArea()="+c2.getArea());
		if(c1 instanceof Shape)
			System.out.println("c1 is a 实验四Shape");
		if(c1 instanceof Rectangle)
			System.out.println("c1 is a 实验四Triangle");
	
	}

}
