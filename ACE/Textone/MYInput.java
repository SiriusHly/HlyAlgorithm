package Textone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MYInput {
public static String readString(){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1);
	String str ="";
	try{
		str= br.readLine();
		
	}
	catch(IOException e){
		System.out.println(e);
	}
	return str;
}
public static int readInt(){
return Integer.parseInt(readString()); 
}
public static double readDouble(){
	return Double.parseDouble(readString());
}
public static byte readByte(){
	return Byte.parseByte(readString());
}
public static Short readShort(){
	return Short.parseShort(readString());
}
public static Long readLong(){
	return Long.parseLong(readString());
	
}
	public static void main (String []args){
		double radius;
		double area;
		final double PI= 3.1415;
		radius =MYInput.readDouble();
		area=radius*radius*PI;
		System.out.println(area);
	}

}
