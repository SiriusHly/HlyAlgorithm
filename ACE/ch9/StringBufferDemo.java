package ch9;

public class StringBufferDemo {

	public StringBufferDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		buffer.append("i am ");
		buffer.append("a teacher");
		System.out.println(buffer.toString());
		System.out.println(buffer.capacity());
		System.out.println(buffer.length());
		buffer.append(" you are");
		System.out.println(buffer.capacity());
		System.out.println(buffer.length());
	}

}
