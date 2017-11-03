package ch12;

import java.util.Scanner;

public class AgeException extends Exception {

	public AgeException() {
		// TODO Auto-generated constructor stub
		super("年龄异常");
	}

	public AgeException(String message) {
		super(message);
	}
	public static void main(String args[]) throws Exception{
		int age=0;
		System.out.println("请输入你的年龄：");
		Scanner sc=new Scanner(System.in);
		age=sc.nextInt();
		if(age>200)
			throw new Exception("年龄异常");
	}
}
