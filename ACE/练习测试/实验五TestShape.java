package 练习测试;

public class 实验五TestShape {

	public 实验五TestShape() {
	}
public void p(实验五Shape s){
	s.draw();
	System.out.println(s.getArea());
}
	public static void main(String[] args) {
实验五TestShape t = new 实验五TestShape();
实验五Shape p1 = new 实验五Circle(5);
实验五Shape p2 = new 实验五Rectangle(4,5);
t.p(p1);
t.p(p2);
	}

}
