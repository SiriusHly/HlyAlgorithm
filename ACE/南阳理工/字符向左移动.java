package 南阳理工;
import java.util.Scanner;
public class 字符向左移动 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	int n = in.nextInt();
	String str = in.next();
	//in.nextLine();
	int s = in.nextInt();
	 char a[] = str.toCharArray();
	for(int i = s ;i<n;i++){
		System.out.print(a[i]);
	}
	for(int i= 0;i<s;i++){
		System.out.print(a[i]);
	}System.out.println();
}
	}

}
