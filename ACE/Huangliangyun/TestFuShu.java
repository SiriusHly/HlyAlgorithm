package Huangliangyun;
import java.util.Scanner;
public class TestFuShu {
	public TestFuShu() {
	
	}
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		FuShu t = new FuShu();
		System.out.println("�����븴����ʵ�����鲿��");
		double a = in.nextDouble();
		double b = in.nextDouble();
		t.set(a,b);
		System.out.println("������Ҫ������븴����ʵ�����鲿��");
		double i = in.nextDouble();
		double j = in.nextDouble();
        t.add(i, j);
        t.print();
		System.out.println("������Ҫ���������ʵ�����鲿��");
		double k = in.nextDouble();
		double l = in.nextDouble();
        t.minus(k, l);
        t.print();
        System.out.println("�����ʵ��Ϊ��"+t.getA());
        System.out.println("������鲿Ϊ��"+t.getA());
	}


}
