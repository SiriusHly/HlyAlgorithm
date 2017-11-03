package ace;
import java.util.Scanner;
public class Shuiti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int i;
int n = input.nextInt();
int [] a = new int [10];
while(n--!=0){
	int s = 0;
	for(i = 0;i<a.length;i++){
		a[i] = input.nextInt();
	}
	int m = input.nextInt();
	for(i=0;i<a.length;i++)
	{
		if(a[i]<=m+30){
			 s++;
		}
	}
	System.out.println(s);
}
	}

}
