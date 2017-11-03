package ch14;

import java.io.*;

public class TxtFileDemo {
  public static void main(String[] args) {
    Writer writer = null;                                                   //��ʼ��

    try {
      writer = new FileWriter("e:\\book\\5.txt");                           //ʵ����

      writer.write("line 1\n");                                          //д�ļ���ͷд�����ļ�ԭ�������ݣ�ԭ���ݱ����ǣ��ü��±��򿪿ɶ���������һ�У������У�
      writer.write("line 2\n");
      writer.write("5678\n");
      writer.write("true\n");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer!=null)
        try {
          writer.close();                                                 //���ļ����ܲ��ɹ����������쳣
        } catch (IOException e) {
        }
    }

    Reader reader=null;

    try {
      reader=new FileReader("e:\\book\\5.txt");
      
      char[] buffer=new char[1024];                                          //�����ַ�������
      int offset;                                                           //offset������Ԫ��ʵ��ʹ�ø���

      
      while((offset=reader.read(buffer))>0){                              //read�������ݷ���buffer�����У�����ֵ�Ƕ��ĸ���,����4���س�������offset
        System.out.print(new String(buffer, 0, offset));                   //�ַ����������ַ���
        System.out.println(offset);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader!=null)
        try {
          reader.close();
        } catch (IOException e) {
        }
    }
  }
}






/*
���1��

line 1
line 2
5678
true
24

���2��4��\nȥ����
line 1line 25678true20





//if((offset=reader.read(buffer))>0){                                //if���Ҳ����

*/

