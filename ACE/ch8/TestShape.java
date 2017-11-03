package ch8;

public class TestShape {

	public TestShape() {
		// TODO Auto-generated constructor stub
	}
	public void printShapeArea(Shape s){
		System.out.println(s.getArea());
	}
	public static void main(String []args){
		Shape c1 = new Circle(3);
		Shape c2 = new Rectangle(3,4);
		Shape c3 = new Triangle(3,4,5);
		TestShape t = new TestShape();//实验四TestShape t
		t.printShapeArea(c1);
		t.printShapeArea(c2);
		t.printShapeArea(c3);
		if(c3 instanceof Triangle){
			Triangle c4= (Triangle)c3;//这是Triangle；
			System.out.println(c4.getA());
		}
		if(c2 instanceof Triangle){
			Triangle c5 = (Triangle)c2;
			System.out.println(c5.getA());
		}
		Shape zhengFangXing = new Shape(){
			//inner kinds
			public double getArea(){
				return 0;
			}
			@Override
			public double getPerimeter() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		zhengFangXing.getArea();
		Math1 ShenTong = new Math1(){

			@Override
			public double max(double a, double b) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public double pingFang(double a) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public double nFang(double a, double b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		ShenTong.getA();
		
	}

}
