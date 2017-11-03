package ace;
import java.util.Scanner;
public class ²»¸ßÐË {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int i,j,max;
int n=in.nextInt();
int []a=new int [1];
while(n-->0){
	max=0;a[0]=1;
	for(int k=1;k<=7;k++){
	i=in.nextInt();j=in.nextInt();
	if(i+j>max){
		max=i+j;
		a[0]=k;
	}
	} 
	if(max>8){
		System.out.println(a[0]);
	}
	else{
		System.out.println(0);
	}
}
	}

}
