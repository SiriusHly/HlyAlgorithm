package ace;
import java.util.Arrays;
import java.util.Scanner;
public class Suijishu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int n = input.nextInt();
int []a=new int [n];
for(int i=0;i<a.length;i++){
	a[i]=input.nextInt();
}
Arrays.sort(a);
for(int i=0;i<a.length;i++){
	for(int j=i+1;j<a.length;j++){
		if(a[i]==a[j]){
			a[i]=0;//从前往后的，a【j】不能为0,，a【i】就会等于0（个人理解）
			n--;
		}
	}
}
System.out.println(n);
int flag=0;
for(int i=0;i<a.length;i++){
	if(a[i]!=0){
		if(flag==0){
		System.out.print(a[i]);flag=1;
	}
		else if(flag==1) {
		System.out.print(" "+a[i]);
	}}
	
}System.out.println();
	}

}
