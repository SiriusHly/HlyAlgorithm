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
		catch(FileNotFoundException e){//�����ļ��������쳣,���Բ���
			System.out.println("not found");
		}
		catch(IOException e){//����I/O�쳣������Ҫ��
			System.out.println("write mistake");
		}
	}
}
