package ch14;

import java.io.*;

class FileInputStreamDemo1{
  public static void main(String[] args)throws   IOException{
    FileInputStream in=new FileInputStream("D:\\java\\workspace\\rj16\\src\\ch14\\FileInputStreamDemo1.java");
    int data;int size=in.available();
    byte[] bb=new byte[size];
    in.read(bb);
    for(int i=0;i<bb.length;i++)
    	System.out.print((char)bb[i]);
    /*
    for(int i=0;i<size;i++){
    	data=in.re.read();
    	System.out.print((char)data);
    }*/
    //data=in.read();                                                     //����һ���ֽڵ����ݣ�read()����ֵΪint
    //while(data!=-1)                                                     //�ļ�δ�����������ݣ�
     // {
     //    System.out.print((char)data);                                  //�����������
      //   data=in.read();                                                //����һ������
     //  }
    //while((data=in.read())!=-1)                                            //��ǰ���Ч��һ�����ȸ�data��ֵ���ж��Ƿ�Ϊ-1����Чdata=in.read();--while����
    //  System.out.print((char)data);
    in.close();
  }
}






/*
���
�������������룬����������ʾ��������



*/