package ��ϰ����;


import java.util.Scanner;
 public class MyException extends Exception{
	private String ErrorMassage;
	private Object a;
	public MyException(){
		
	}
	public MyException(String a){
		
		super(a);//�̳и���Ĺ��췽����a��Exception�Ĳ���
		ErrorMassage=a;
		
	}
	public String getMessege(){
		return ("����,����Ϊ"+ErrorMassage+"��������100��");

	}
	 class Test1{
		public void cth() throws MyException {
			Scanner sc=new Scanner(System.in);
			double age=sc.nextDouble();
			if(age>100)
				throw new MyException(String.valueOf(age));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyException f = new MyException();
		Test1 w;
		w=f.new Test1();
		try{
			
		    w.cth();
		    
		}
		catch(MyException e){
			System.out.println(e);
			
		}
//		û��һ������MyException�ķ��ʵ���ǿɷ��ʵġ�������һ������MyException�ķ��ʵ�����޶�����(����x����A()x��MyException��ʵ��)��

	}

}
