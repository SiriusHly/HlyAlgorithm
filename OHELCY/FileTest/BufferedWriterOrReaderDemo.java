package FileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterOrReaderDemo {

	public BufferedWriterOrReaderDemo() {
	}
	public static void main(String []args){
		BufferedWriter writer = null;//no Stream;
		BufferedReader reader = null;
		try {
			writer = new BufferedWriter(new FileWriter("f:\\book\\hly3.txt"));
			//FileWriter 方法添加地址；
			writer.write("1,2,3,4,5");
			writer.newLine();
			writer.write("1,2,3,4");
			for(int i=0;i<100;i++){
				writer.write(String.valueOf(i)+" ");
			}
			writer.close();//记得加上close（）：
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
		reader= new  BufferedReader(new FileReader("f:\\book\\hly3.txt"));
		String buf;
		
			while((buf=reader.readLine())!=null){
				System.out.println(buf);
				
			}
			
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
