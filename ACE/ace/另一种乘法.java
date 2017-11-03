package ace;
import java.util.Scanner;
public class ÁíÒ»ÖÖ³Ë·¨ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int i,j;
int s = 0 ;
int t=in.nextInt();
while(t-->0){
	int n=in.nextInt();int m=in.nextInt();
	int k;
	s=0;
	while(n>0){
		k=m;
		i=n%10;
		while(k>0){
		j=k%10;
		s+=i*j;
		k/=10;
		}
		n/=10;
		k=m;
	}
}
System.out.println(s);
	}

}
