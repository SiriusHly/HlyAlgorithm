package ace;

//import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Main
{
public static void main(String args[]) throws Exception
{
Scanner input =new Scanner(System.in);
int []a = new int [3];
for(int i=0;i<a.length;i++){
	 a[i]=input.nextInt();
}
for(int i=0;i<a.length;i++){
	for(int j=i;j<a.length;j++){
		if(a[i]>a[j]){
			int t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
	}
}
for(int i=0;i<a.length;i++){
	System.out.print(a[i]+" ");
}
}
}




