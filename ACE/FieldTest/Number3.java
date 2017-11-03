package FieldTest;

import java.io.File;
import java.io.FileWriter;

public class Number3 {

	public Number3() {
	}
	public static void main(String[]args)throws Exception{
		FileWriter f = new FileWriter(new File("f:\\book\\hly8.txt"));
		byte[]bb= new byte[1024];
		
		for(int i=0;i<100;i++){
			f.write(Integer.toString(i)+" ");
		}
		f.close();
		int size=bb.length;
		for(int i=0;i<size;i++){
			System.out.print(Integer.toString(i));
		}
			
		
	}

}
