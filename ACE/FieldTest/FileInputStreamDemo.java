package FieldTest;

import java.io.FileInputStream;
import java.io.*;

public class FileInputStreamDemo {

	public FileInputStreamDemo() {
	}
	public static void main(String []args)throws IOException{
		FileInputStream in = new FileInputStream("f:\\book\\hly7.txt");
		int data;
		int size = in.available();
		byte []bb= new byte[size];
		/*in.read(bb);
	for(int i=0;i<bb.length;i++){
		System.out.print((char)bb[i]);
		
	}*/
	/*for(int i=0;i<size;i++){
		data=in.read();
		System.out.print((char)data);
	}
	*/
		while((data=in.read())!=-1)   {                                         //和前面的效果一样，先给data赋值再判断是否为-1，等效data=in.read();--while结束
	    System.out.print((char)data);
	    
	    }
		in.close();//放在这里
	  }
	//while(data!=-1)                                                     //文件未结束（有数据）
    // {
    //    System.out.print((char)data);                                  //输出读的数据
     //   data=in.read();                                                //读下一个数据
    //  }
	
	}


