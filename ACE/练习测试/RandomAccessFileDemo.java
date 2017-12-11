package 练习测试;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public RandomAccessFileDemo() {
	}
	public static void main(String []args){
		RandomAccessFile raf = null;
		try {
			raf =new RandomAccessFile("f:\\book\\exchangeSystem.txt", "rw");
			raf.writeInt(10);
			raf.writeChar('a');
			raf.seek(4);//第四个字节
			char c = raf.readChar();
			System.out.println(c);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
