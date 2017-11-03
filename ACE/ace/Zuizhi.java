package ace;
import java.util.Scanner;
public class Zuizhi {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		// TODO Auto-generated method stub
int []a=new int[5];
for(int i=0;i<a.length;i++){
	a[i]=input.nextInt();
}
for(int i=0;i<a.length;i++){
	for(int j=i+1;j<a.length;j++){
		if(a[i]>a[j]){
			int t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
	}
}
System.out.print(a[0]+" "+a[4]);

	}

}
