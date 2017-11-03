package Stack;

import java.util.Scanner;

public class SqStack implements IStack {
	private Object[] stackElem;
	private int top;

	public SqStack(int maxSize) {
		top = 0;
		stackElem = new Object[maxSize];
	}

	@Override
	public void clear() {
		top = 0;
	}

	@Override
	public boolean isEmpty() {

		return top == 0;
	}

	@Override
	public int length() {

		return top;
	}

	@Override
	public Object peek() {
		if (!isEmpty())
			return stackElem[top - 1];
		else
			return null;
	}

	@Override
	public void push(Object x) throws Exception {
		if (top == stackElem.length)
			throw new Exception("Õ»ÒÑÂú");
		else
			stackElem[top++] = x;
	}

	@Override
	public Object pop() {
		if(isEmpty())
			return null;
		return stackElem[--top];
	}

	@Override
	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.println(stackElem[i].toString() + " ");
	}

	@Override
	//ÅÐ¶Ï»ØÎÄ´®
	public  boolean isPalindrome(String str) throws Exception {
		boolean flag = true;
		SqStack st1 = new SqStack(1024);
		SqStack st2 = new SqStack(1024);
		int stLength =str.length()/2;
		for(int i=0;i<stLength;i++){
			st1.push(str.charAt(i));
			st2.push(str.charAt(str.length()-i-1));
		}
		for(int i=stLength-1;i>=0;i--){
			if(st1.stackElem[i]!=st2.stackElem[i]){
				flag=false;
				break;
			}
		}
		return flag;
	}
	

}
