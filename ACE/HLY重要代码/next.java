package HLY重要代码;
import java.util.Scanner;
public class next {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
int p=0;
int i;
next :for(i=100;i<=200;i++){
	for(int j=2;j<i;j++){
		if(i%j==0){
			continue next;
		}
	}
	p++;
	System.out.print(i+" ");
	if(p%10==0){
		System.out.println();
	}
}
	int n = 0;//记得赋初值
	double y=0;
	int t = in.nextInt();
	switch(n){
	case 0:
		y=t*t-1;break;
	case 1:
	case 2:
		y=t*t*t-2*t-2;break;
	case 3:
	case 4:
		y=t*t-t*Math.sin(t);break;
	case 5:
	case 6:
		y=t+1;break;
	default:
		y=t-1;break;
		}
	System.out.println(y);
	}
		
}


	

	


