package ace;
import java.util.Scanner;
public class Shiyan2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int [] a = new int [100];
		int c = in.nextInt();
		for(int i=0;i<c;i++){
		a[i] =  in.nextInt();
		}
		Shiyan2 shuiti = new Shiyan2();
		System.out.println( shuiti.Some(c,a)+" "+shuiti.Ave(c,a));
	}
 double Some(int c,int [] a){
	double s = 0;
	for(int i=0;i<c;i++){
	s+=a[i];
	}
	return s;
}
 double Ave(int c,int []a){
	 double ave=Some(c,a)/c;
	 return ave;
 }
	
}
