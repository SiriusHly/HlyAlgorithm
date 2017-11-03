package FieldTest;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {

	public FileInputStreamDemo2() {
	}
public static void main(String []args)throws Exception{
	int size;
	FileInputStream f = new FileInputStream("f:\\book\\hly7.txt");
	System.out.println("Total Available Byte: "+(size=f.available()));
	for(int i=0;i<size;i++){
		char temp= (char)f.read();
		System.out.print(temp);
	}
	f.close();
}
}
