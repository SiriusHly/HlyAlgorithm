package 南阳理工;
import java.util.Arrays;
import java.util.Scanner;
public class 最值加强版465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	String str = in.next();
	char [] a= str.toCharArray();
	if(a.length==1&&a[0]=='0'){
		System.out.println(0+" "+0);
	}
	else{
	Arrays.sort(a);
	for(int i=a.length-1;i>=0;i--){
		System.out.print(a[i]);
	}
	System.out.print(" ");
	for(int i=0;i<a.length;i++){
		if(a[i]!='0'){
		System.out.print(a[i]);
	}
	}
	System.out.println();
}
}
	}

}
