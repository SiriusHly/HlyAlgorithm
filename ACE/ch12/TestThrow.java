package ch12;

public class TestThrow {
	static int divide(int a,int b) throws Exception{
		if(b==0)
			throw new Exception("����Ϊ��");
		int c=0;
		c=a/b;
		return c;
	}
	static int myDivide(int a,int b) throws Exception{
		int c=0;
		try {
			c=divide(a,b);
		} catch (Exception e) {
			throw new Exception("����divideʱ����"+e.getMessage());
		}
		return c;
	}
	public static void main(String[] args) {
		int a=3,b=0,c=0;
		try {
			c=myDivide(a,b);
		} catch (Exception e) {
			System.out.println("����myDivide���ִ���: "+e.getMessage());
		}
		System.out.println("c="+c);

	}

}
