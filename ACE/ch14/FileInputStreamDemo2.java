package ch14;

import java.io.*;

class FileInputStreamDemo2 {
  public static void main(String args[]) throws Exception {                            //�쳣�׸��ϼ����ô������ﲻ���𲶻��쳣
    int size;

    InputStream f=new FileInputStream("FileInputStreamDemo1.java");                   //��ǰĿ¼���ļ� ����ǰĿ¼Ϊ.class���ڰ����ļ��У�������rj14��   InputStream�ǳ����࣬�����Ƕ�̬

    //InputStream f=new FileInputStream("E:\\book\\out.txt");        

    System.out.println("Total Available Bytes:"+(size = f.available()));              //����ļ�f�Ĵ�С���ֽ�����
    for (int i=0; i < size; i++) { 
      char temp=(char)f.read();                                                     //read����ÿ�ζ�һ���ֽڣ�����Ҳ�������ˣ���������,ת��Ϊ�ַ������
      System.out.print(temp); 
    }

    f.close();
  }
}






/*
���1����InputStream f=new FileInputStream("FileInputStreamDemo1.java")  ��
  Total Available Bytes:712

��FileInputStreamDemo1.javaԴ������룬���ְ��ֽڶ��밴�ֽ������ʾΪ���룩



���2����InputStream f=new FileInputStream("E:\\book\\out.txt");   ��
  Total Available Bytes:3
��E:\\book\\out.txt�ļ����ݣ�

abc

*/