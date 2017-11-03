package ch14;

import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFileDemo {
  public static void main(String[] args) {
    RandomAccessFile randomAccessFile=null;

    try {
      randomAccessFile = new RandomAccessFile("e:\\book\\2.txt", "rw");

      randomAccessFile.writeInt(100);                                              //int 4字节，char 2字节
      randomAccessFile.writeChar('a');

      randomAccessFile.seek(4);                                               //seek指示着读或写的位置，读或写时seek随着移动，指向字符a（0-3的4个字节是整数100）
      char charData = randomAccessFile.readChar();                             
      System.out.println("charData = " + charData);

         
      randomAccessFile.writeInt(5678);                                      //读字符a后（字符是2字节），指针移动到a后面6位置，从此处写整数5678
      
      long p1=randomAccessFile.getFilePointer();                           // 写完整数5678指针已到其后，p1=10
      System.out.println("pointer1="+p1);
      

      randomAccessFile.seek(0);                                         //到0位置，读a1=100
      int a1=randomAccessFile.readInt();
      System.out.println("a1="+a1);

      
      randomAccessFile.seek(0);                                   //到0位置，200代替100
      randomAccessFile.writeInt(200);
      randomAccessFile.seek(0);                                  //到0位置，读a2=200
      int a2=randomAccessFile.readInt();
      System.out.println("a2="+a2);
 
      randomAccessFile.seek(6);                                  //到6位置，读a3=5678,指针到10，读之前的数据：200（0-3），'a'（4-5），5678（6-9）
      int a3=randomAccessFile.readInt();
      System.out.println("a3="+a3);
      
      long p2=randomAccessFile.getFilePointer();                //pointer2=10
      System.out.println("pointer2="+p2);
 
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (randomAccessFile!=null){
        try {
           randomAccessFile.close();
        } catch (IOException e) {
        }
      }
    }
  }
}


/*
结果：（int 4字节，char 2字节）

charData=a
pointer1=10
a1=100
a2=200
a3=5678
pointer2=10
*/
