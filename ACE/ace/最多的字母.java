package ace;
import java.util.Scanner;
public class ×î¶àµÄ×ÖÄ¸ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int []total=null;
int t = in.nextInt();
while(t-->0){
	total = new int [200];
	String str=in.next();
	char []arry=str.toCharArray();
	for(int i=0;i<arry.length;i++){
		total[arry[i]]++;
	}
	int max=0;
	int k=0;
	for(int i=0;i<200;i++){
		if(total[i]>max){
			max=total[i];
			k=i;
		}
	}
System.out.println((char)k);
}

	}

}
