package Huangliangyun;

public class TestShape1 {

	public TestShape1() {
		
	}
public void printCharacter(Shape1 s){
	s.draw();
	System.out.println(s.getArea());
	
}
	public static void main(String[] args) {
		Shape1 p1 = new Circle1(3);
		Shape1 p2 = new Rectangle1(4,5);
		TestShape1  t = new TestShape1 ();
		t.printCharacter(p1);
		t.printCharacter(p2);

	}

}
