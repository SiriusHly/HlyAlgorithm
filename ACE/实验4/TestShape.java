package ʵ��4;
import java.util.Scanner;
public class TestShape {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("������Բ�İ뾶");
		double r = in.nextDouble();
		Shape p1 = new MyCircle(r);
		System.out.println("Բ�������"+p1.getArea());
		System.out.println("Բ���ܳ���"+p1.getPerimeter());
		System.out.println("��������εĳ��Ϳ�");
        double a = in.nextDouble();
        double b = in.nextDouble();
Shape p2 = new Rectangle(a,b);
System.out.println("���ε������"+p2.getArea());
System.out.println("���ε��ܳ���"+p2.getPerimeter());
System.out.println("�����������ε�������");
double i = in.nextDouble();
double j = in.nextDouble();
double k = in.nextDouble();
Shape p3 = new Triangle(i,j,k);
System.out.println("�����ε������"+p3.getArea());
System.out.println("�����ε��ܳ���"+p3.getPerimeter());
	};

}
