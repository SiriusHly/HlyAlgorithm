package Stack;

import java.util.Scanner;
import Stack.*;

public class StackTest {

	public static void main(String[] args) throws Exception {
		SqStack s = new SqStack(1024);
		StackTest st = new StackTest();
		Scanner in = new Scanner(System.in);
		String str  = in.next();
		
		
		//System.out.println(s.isPalindrome(str));
		System.out.println(st.huiwen(str));

	}
	
	public boolean huiwen(String str){
		int i=0,j=str.length()-1;
		while((i<j)&&str.charAt(i)==str.charAt(j)){
			i++;
			j--;
		}
		if(i>=j)
			return true;
		return false;
		
	}

	
}
