package 练习测试;


import java.util.Scanner;
 public class MyException extends Exception{
	private String ErrorMassage;
	private Object a;
	public MyException(){
		
	}
	public MyException(String a){
		
		super(a);//继承父类的构造方法，a是Exception的参数
		ErrorMassage=a;
		
	}
	public String getMessege(){
		return ("错误,岁数为"+ErrorMassage+"岁数大于100了");

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
//		没有一个类型MyException的封闭实例是可访问的。必须用一个类型MyException的封闭实例来限定分配(例如x。新A()x是MyException的实例)。

	}

}
