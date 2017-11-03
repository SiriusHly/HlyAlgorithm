package 实验4;
import java.util.Scanner;
public class TestShape {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入圆的半径");
		double r = in.nextDouble();
		Shape p1 = new MyCircle(r);
		System.out.println("圆的面积是"+p1.getArea());
		System.out.println("圆的周长是"+p1.getPerimeter());
		System.out.println("请输入矩形的长和宽");
        double a = in.nextDouble();
        double b = in.nextDouble();
Shape p2 = new Rectangle(a,b);
System.out.println("矩形的面积是"+p2.getArea());
System.out.println("矩形的周长是"+p2.getPerimeter());
System.out.println("请输入三角形的三条边");
double i = in.nextDouble();
double j = in.nextDouble();
double k = in.nextDouble();
Shape p3 = new Triangle(i,j,k);
System.out.println("三角形的面积是"+p3.getArea());
System.out.println("三角形的周长是"+p3.getPerimeter());
	};

}
