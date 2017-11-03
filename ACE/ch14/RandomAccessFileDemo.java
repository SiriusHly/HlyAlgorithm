package ch14;

import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFileDemo {
  public static void main(String[] args) {
    RandomAccessFile randomAccessFile=null;

    try {
      randomAccessFile = new RandomAccessFile("e:\\book\\2.txt", "rw");

      randomAccessFile.writeInt(100);                                              //int 4�ֽڣ�char 2�ֽ�
      randomAccessFile.writeChar('a');

      randomAccessFile.seek(4);                                               //seekָʾ�Ŷ���д��λ�ã�����дʱseek�����ƶ���ָ���ַ�a��0-3��4���ֽ�������100��
      char charData = randomAccessFile.readChar();                             
      System.out.println("charData = " + charData);

         
      randomAccessFile.writeInt(5678);                                      //���ַ�a���ַ���2�ֽڣ���ָ���ƶ���a����6λ�ã��Ӵ˴�д����5678
      
      long p1=randomAccessFile.getFilePointer();                           // д������5678ָ���ѵ����p1=10
      System.out.println("pointer1="+p1);
      

      randomAccessFile.seek(0);                                         //��0λ�ã���a1=100
      int a1=randomAccessFile.readInt();
      System.out.println("a1="+a1);

      
      randomAccessFile.seek(0);                                   //��0λ�ã�200����100
      randomAccessFile.writeInt(200);
      randomAccessFile.seek(0);                                  //��0λ�ã���a2=200
      int a2=randomAccessFile.readInt();
      System.out.println("a2="+a2);
 
      randomAccessFile.seek(6);                                  //��6λ�ã���a3=5678,ָ�뵽10����֮ǰ�����ݣ�200��0-3����'a'��4-5����5678��6-9��
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
�������int 4�ֽڣ�char 2�ֽڣ�

charData=a
pointer1=10
a1=100
a2=200
a3=5678
pointer2=10
*/
