package Huangliangyun;
import java.util.Scanner;
public class TestFuShu {
	public TestFuShu() {
	
	}
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		FuShu t = new FuShu();
		System.out.println("请输入复数的实部和虚部：");
		double a = in.nextDouble();
		double b = in.nextDouble();
		t.set(a,b);
		System.out.println("请输入要相加输入复数的实部和虚部：");
		double i = in.nextDouble();
		double j = in.nextDouble();
        t.add(i, j);
        t.print();
		System.out.println("请输入要相减复数的实部和虚部：");
		double k = in.nextDouble();
		double l = in.nextDouble();
        t.minus(k, l);
        t.print();
        System.out.println("这个数实部为："+t.getA());
        System.out.println("这个数虚部为："+t.getA());
	}


}
