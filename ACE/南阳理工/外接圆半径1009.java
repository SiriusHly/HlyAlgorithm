package 南阳理工;
import java.util.Scanner;
public class 外接圆半径1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
while(in.hasNext()){
	double a = in.nextDouble();
	double b = in.nextDouble();
	double c = in.nextDouble();
	double s,r,p;
	p = (a+b+c)/2;
	s=Math.sqrt(p*(p-a)*(p-b)*(p-c));
	r = (a*b*c)/(4*s);
	System.out.printf("%.2f\n",r);
	}
	}

}
