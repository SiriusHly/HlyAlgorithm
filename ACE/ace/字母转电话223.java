package ace;
import java.util.Scanner;
public class ×ÖÄ¸×ªµç»°223 {

	public static void main(String[] args) {
		// TODO Auto-generated method ,7-pqrs,8-tuv,9-wxyz£©,
Scanner in=new Scanner(System.in);
int t=in.nextInt();
while(t-->0){
	String str=in.next();
	char []a=str.toCharArray();
	int []b=new int [20];
	for(int i=0;i<a.length;i++){
		if(a[i]=='a'||a[i]=='b'||a[i]=='c'){
			b[i]=2;
		}
		if(a[i]=='d'||a[i]=='e'||a[i]=='f'){
			b[i]=3;
		}
		if(a[i]=='g'||a[i]=='h'||a[i]=='i'){
			b[i]=4;
		}
		if(a[i]=='j'||a[i]=='k'||a[i]=='l'){
			b[i]=5;
		}
		if(a[i]=='m'||a[i]=='n'||a[i]=='o'){
			b[i]=6;
		}
		if(a[i]=='p'||a[i]=='q'||a[i]=='r'||a[i]=='s'){
			b[i]=7;
		}
		if(a[i]=='t'||a[i]=='u'||a[i]=='v'){
			b[i]=8;
		}
		if(a[i]=='w'||a[i]=='x'||a[i]=='y'||a[i]=='z'){
			b[i]=9;
		}
		
	}
	for(int i=0;i<a.length;i++){
		System.out.print(b[i]);
	}System.out.println();
}
	}

}
