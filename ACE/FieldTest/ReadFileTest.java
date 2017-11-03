package FieldTest;

import java.io.File;
import java.io.FileInputStream;

public class ReadFileTest {

	public ReadFileTest() {
	}
	public static void mian(String []j)throws Exception{
		byte temp []= new byte[1024];
		File f = new File("f:\\book\\hly4");
		FileInputStream readfile = new FileInputStream(f);
		int b;
		while((b=readfile.read(temp,0,25))!=-1){
			String s = new String(temp,0,b);
		}
		readfile.close();
		//System.out.print(s);
	}

}
