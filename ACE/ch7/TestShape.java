package ch7;

public class TestShape {
//有意思，重点看，重点理解；
	public TestShape() {
		// TODO Auto-generated constructor stub
	}
	public void printShapeArea(Shape s){
		System.out.println(s.getArea());//把c1调到了这里；
	}
	public static void main(String []args){
		//实验四Circle c1 = new 实验四Circle (3);
		Shape c1 = new Circle(3);
		Shape c2 = new Rectangle(3,4);
		Shape c3 = new Triangle(3,4,5);
		TestShape t = new TestShape();//创建对象；
		t.printShapeArea(c1);
		t.printShapeArea(c2);
		t.printShapeArea(c3);
		if(c3 instanceof Triangle){
			/*instanceof这个对象是否是这个特定类或是他的子类的一个实例*/
			Triangle c4 = (Triangle)c3;
			System.out.println(c4.getA());//上面Shape 长2的这个a赋值给了triangle里的getA;输出3；
		}
		if(c2 instanceof Triangle){
			Triangle c5 = (Triangle)c2;
			System.out.println(c5.getA());
		}
	}

}
