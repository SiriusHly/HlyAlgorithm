package ace;
import java.util.Scanner;
public class ÈÕÆÚ¼ÆËã {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int [] a={0,31,28,31,30,31,30,31,31,30,31,30,31};
int t=in.nextInt();
while(t-->0){
	int y=in.nextInt(),m=in.nextInt(),d=in.nextInt();
	int s;
	s=d;
	for(int i=0;i<m;i++){
		s+=a[i];
	}
	if((m>2)&&y%4==0&&y%100!=0||y%400==0){
		s++;
	}
	System.out.println(s);
}
	}

}
