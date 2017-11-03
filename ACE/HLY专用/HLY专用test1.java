package HLY专用;
import java.util.Scanner;
public class HLY专用test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
