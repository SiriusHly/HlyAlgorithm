package ��ϰ����;

public class ʵ����TestShape {

	public ʵ����TestShape() {
	}
	public void pt(ʵ����Shape s){
		System.out.println(s.getArea());
		System.out.println(s.getPerimeter());
		
	}
	public static void main(String[] args) {
		
ʵ����Shape p1 = new ʵ����Circle(5);
ʵ����Shape p2 = new ʵ����Rectangle(2,8);
ʵ����Shape p3 = new ʵ����Triangle(3,4,5);
ʵ����TestShape t = new ʵ����TestShape();
t.pt(p1);
t.pt(p2);
t.pt(p3);



	}

}
