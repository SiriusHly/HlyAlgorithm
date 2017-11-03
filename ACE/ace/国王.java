package ace;
import java.util.Arrays;
import java.util.Scanner;
public class ¹úÍõ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int i,j,s,k,l;
int t=in.nextInt();
while(t-->0){
	s=0;k=0;
	int n=in.nextInt();
	int []a=new int [n];int []b=new int [n];
	for(i=0;i<n;i++){
		a[i]=in.nextInt();
	}
	for(i=0;i<n;i++){
		b[i]=in.nextInt();
	}
	Arrays.sort(a);Arrays.sort(b);
	for(i=0;i<n;i++){
		if(a[i]>b[i]){
			s+=2;
		}
		else if(a[i]<b[i]){
			k+=2;
		}
		else if(a[i]==b[i]){
			s+=1;k+=1;
		}
	}

if(s>k){
	System.out.println("X");
}
else if(s<k){
	System.out.println("Y");
}
else if(s==k){
	System.out.println("none");
}
}
	}

}
