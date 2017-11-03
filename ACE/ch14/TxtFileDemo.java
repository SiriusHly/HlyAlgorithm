package ch14;

import java.io.*;

public class TxtFileDemo {
  public static void main(String[] args) {
    Writer writer = null;                                                   //初始化

    try {
      writer = new FileWriter("e:\\book\\5.txt");                           //实例化

      writer.write("line 1\n");                                          //写文件从头写，若文件原来有内容，原内容被覆盖，用记事本打开可读，内容在一行（不换行）
      writer.write("line 2\n");
      writer.write("5678\n");
      writer.write("true\n");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer!=null)
        try {
          writer.close();                                                 //关文件可能不成功，可能抛异常
        } catch (IOException e) {
        }
    }

    Reader reader=null;

    try {
      reader=new FileReader("e:\\book\\5.txt");
      
      char[] buffer=new char[1024];                                          //定义字符型数组
      int offset;                                                           //offset：数组元素实际使用个数

      
      while((offset=reader.read(buffer))>0){                              //read读的数据放在buffer数组中，返回值是读的个数,包括4个回车符存入offset
        System.out.print(new String(buffer, 0, offset));                   //字符型数组变成字符串
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
结果1：

line 1
line 2
5678
true
24

结果2（4个\n去掉）
line 1line 25678true20





//if((offset=reader.read(buffer))>0){                                //if语句也可以

*/

