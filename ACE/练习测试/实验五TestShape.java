package ��ϰ����;

public class ʵ����TestShape {

	public ʵ����TestShape() {
	}
public void p(ʵ����Shape s){
	s.draw();
	System.out.println(s.getArea());
}
	public static void main(String[] args) {
ʵ����TestShape t = new ʵ����TestShape();
ʵ����Shape p1 = new ʵ����Circle(5);
ʵ����Shape p2 = new ʵ����Rectangle(4,5);
t.p(p1);
t.p(p2);
	}

}
