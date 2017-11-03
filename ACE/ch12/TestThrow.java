package ch12;

public class TestThrow {
	static int divide(int a,int b) throws Exception{
		if(b==0)
			throw new Exception("除数为零");
		int c=0;
		c=a/b;
		return c;
	}
	static int myDivide(int a,int b) throws Exception{
		int c=0;
		try {
			c=divide(a,b);
		} catch (Exception e) {
			throw new Exception("调用divide时出错："+e.getMessage());
		}
		return c;
	}
	public static void main(String[] args) {
		int a=3,b=0,c=0;
		try {
			c=myDivide(a,b);
		} catch (Exception e) {
			System.out.println("调用myDivide出现错误: "+e.getMessage());
		}
		System.out.println("c="+c);

	}

}
