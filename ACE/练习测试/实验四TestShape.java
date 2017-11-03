package 练习测试;

public class 实验四TestShape {

	public 实验四TestShape() {
	}
	public void pt(实验四Shape s){
		System.out.println(s.getArea());
		System.out.println(s.getPerimeter());
		
	}
	public static void main(String[] args) {
		
实验四Shape p1 = new 实验四Circle(5);
实验四Shape p2 = new 实验四Rectangle(2,8);
实验四Shape p3 = new 实验四Triangle(3,4,5);
实验四TestShape t = new 实验四TestShape();
t.pt(p1);
t.pt(p2);
t.pt(p3);



	}

}
