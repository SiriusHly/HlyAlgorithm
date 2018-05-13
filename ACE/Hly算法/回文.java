package Hly算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 回文 {

	public 回文() {
	}
	
	public static boolean huiwen(String str){
		int i =0,j = str.length()-1;
		while(i<j&&str.charAt(i)== str.charAt(j)){
				i++;
				j--;
		}
		if(i>=j)
			return true;
					return false;
	}
	
	public static boolean stackAndueue(String str){
		Queue Q  = new LinkedList();
		Stack s = new Stack();
		for(int i= 0;i<str.length();i++){
			s.push(str.charAt(i));
			Q.offer(str.charAt(i));
		}
			while(!s.isEmpty()){
				if(!s.pop().equals(Q.poll())){
					break;
				}
			}
			if(!s.isEmpty())
				return false;
			return true;
			
		
	}
	public static void main(String []v){
		System.out.println(huiwen("abaavba"));
		System.out.println(stackAndueue("ababa"));
	}

}
