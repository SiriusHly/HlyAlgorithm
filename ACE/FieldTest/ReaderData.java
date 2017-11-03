package FieldTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReaderData {
public static InputStreamReader inreader = new InputStreamReader(System.in);
public static BufferedReader breader = new BufferedReader(inreader);
public static char readChar()throws Exception{
	String str;
	System.out.println("please input a char");
	str = breader.readLine();
	return str.charAt(0);
	
}
public static int readInt()throws Exception{
	String str ;
	System.out.println("please input a namber ");
	str = breader.readLine();
	str=str.trim();
	return Integer.parseInt(str);
	
}
public static String readString() throws Exception{
	String str;
	System.out.println("please input String");
	str = breader.readLine();
	return str.trim();
	
}
public static Float readFloat() throws Exception{
	String str;
	System.out.println("please input a float namber");
	str= breader.readLine();
	str=str.trim();
	return Float.parseFloat(str);
}
public static Double readDouble() throws Exception{
	String str;
	System.out.println("please input a double number");
	str= breader.readLine();
	str=str.trim();
return (double)Float.parseFloat(str);	
}
public static Boolean readBoolean()throws Exception{
	String str;
	System.out.println("please input a boolan");
	str = breader.readLine();
	str=str.trim();
	return Boolean.parseBoolean(str);
	
}
	public static void main(String []args) throws Exception{
		System.out.println(readChar());
		System.out.println(readInt());
		System.out.println(readFloat());
		System.out.println(readDouble());
		System.out.println(readBoolean());
		System.out.println(readString());
		
		
	}

}
