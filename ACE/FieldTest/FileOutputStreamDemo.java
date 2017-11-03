package FieldTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public FileOutputStreamDemo() {
	}
/*public static void main(String []args) throws Exception{
	byte bb [] = new byte[100];
bb="hello word".getBytes();
file.write(bb);
file.close();
}*/
	public static void main(String []args){
		try{
		FileOutputStream f = new FileOutputStream("f:\\book\\hly9");
		byte bb[] = new byte[100];
		bb="hello word".getBytes();
		f.write(bb);
		f.close();
		}
		catch(FileNotFoundException e){//捕获文件不存在异常,可以不用
			System.out.println("not found");
		}
		catch(IOException e){//捕获I/O异常，必须要用
			System.out.println("write mistake");
		}
	}
}
