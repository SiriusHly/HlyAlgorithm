package Fuxi4;

public class TestShape {

	public TestShape() {
	}

	public static void main(String[] args) {
    Shape p1 =new Circle(3);
    System.out.println(p1.getArea()+" "+p1.getPerimeter());
    Shape p2 = new Traiangle(3,4,5);
    System.out.println(p2.getArea()+" "+p2.getPerimeter());
	}

}
