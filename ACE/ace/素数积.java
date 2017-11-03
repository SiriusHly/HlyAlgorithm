package ace;
import java.util.Scanner;
public class ËØÊı»ı {
public static boolean fact(int n){
	int i;
	for(i=2;i<=Math.sqrt(n);i++){
		if(n%i==0){
			return false;
		}
	}
	return true;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner (System.in);
int  t =in.nextInt();
while(t-->0){
	long s=1;
	int m=in.nextInt();
	for(int  i=2;i<=m;i++){
		if(fact(i)){
			s*=i;
			s%=1000000;
		}
	}
	System.out.println(s);
}
	}

}
