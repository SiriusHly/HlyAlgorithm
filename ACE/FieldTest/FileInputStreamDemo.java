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
		while((data=in.read())!=-1)   {                                         //��ǰ���Ч��һ�����ȸ�data��ֵ���ж��Ƿ�Ϊ-1����Чdata=in.read();--while����
	    System.out.print((char)data);
	    
	    }
		in.close();//��������
	  }
	//while(data!=-1)                                                     //�ļ�δ�����������ݣ�
    // {
    //    System.out.print((char)data);                                  //�����������
     //   data=in.read();                                                //����һ������
    //  }
	
	}


