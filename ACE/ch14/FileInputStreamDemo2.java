package ch14;

import java.io.*;

class FileInputStreamDemo2 {
  public static void main(String args[]) throws Exception {                            //异常抛给上级调用处，这里不负责捕获异常
    int size;

    InputStream f=new FileInputStream("FileInputStreamDemo1.java");                   //当前目录下文件 ，当前目录为.class所在包的文件夹，这里是rj14；   InputStream是抽象类，这里是多态

    //InputStream f=new FileInputStream("E:\\book\\out.txt");        

    System.out.println("Total Available Bytes:"+(size = f.available()));              //获得文件f的大小（字节数）
    for (int i=0; i < size; i++) { 
      char temp=(char)f.read();                                                     //read（）每次读一个字节，换行也读进来了，返回整数,转换为字符型输出
      System.out.print(temp); 
    }

    f.close();
  }
}






/*
结果1：（InputStream f=new FileInputStream("FileInputStreamDemo1.java")  ）
  Total Available Bytes:712

（FileInputStreamDemo1.java源程序代码，汉字按字节读入按字节输出显示为乱码）



结果2：（InputStream f=new FileInputStream("E:\\book\\out.txt");   ）
  Total Available Bytes:3
（E:\\book\\out.txt文件内容）

abc

*/