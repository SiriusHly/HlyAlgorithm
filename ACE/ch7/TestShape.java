package ch7;

public class TestShape {
//����˼���ص㿴���ص���⣻
	public TestShape() {
		// TODO Auto-generated constructor stub
	}
	public void printShapeArea(Shape s){
		System.out.println(s.getArea());//��c1���������
	}
	public static void main(String []args){
		//ʵ����Circle c1 = new ʵ����Circle (3);
		Shape c1 = new Circle(3);
		Shape c2 = new Rectangle(3,4);
		Shape c3 = new Triangle(3,4,5);
		TestShape t = new TestShape();//��������
		t.printShapeArea(c1);
		t.printShapeArea(c2);
		t.printShapeArea(c3);
		if(c3 instanceof Triangle){
			/*instanceof��������Ƿ�������ض���������������һ��ʵ��*/
			Triangle c4 = (Triangle)c3;
			System.out.println(c4.getA());//����Shape ��2�����a��ֵ����triangle���getA;���3��
		}
		if(c2 instanceof Triangle){
			Triangle c5 = (Triangle)c2;
			System.out.println(c5.getA());
		}
	}

}
