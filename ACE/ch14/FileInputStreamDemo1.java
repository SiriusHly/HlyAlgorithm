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
    //data=in.read();                                                     //读下一个字节的数据，read()返回值为int
    //while(data!=-1)                                                     //文件未结束（有数据）
     // {
     //    System.out.print((char)data);                                  //输出读的数据
      //   data=in.read();                                                //读下一个数据
     //  }
    //while((data=in.read())!=-1)                                            //和前面的效果一样，先给data赋值再判断是否为-1，等效data=in.read();--while结束
    //  System.out.print((char)data);
    in.close();
  }
}






/*
结果
（输出本程序代码，所有中文显示？？？）



*/