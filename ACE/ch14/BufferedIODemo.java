package ch14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.io.*;

public class BufferedIODemo {
	 public static void main(String[] args) {
	    BufferedWriter writer = null;                                                   //初始化
	    try {
	      writer = new BufferedWriter(new FileWriter("e:\\book\\6.txt"));                    //BufferedWriter的构造方法需要的参数类型是FileWriter对象     
	     
	      writer.write("line 1\n");                                                  //写文件从头写，若文件原来有内容，原内容被覆盖，用记事本打开可读,记事本里看到的是另起一行（有换行，但换行不算写入文件的字符串）
	      writer.newLine();                                                        //另起一行（换行）
	      writer.write("line 2");
	      writer.newLine();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      if (writer!=null)
	        try {
	          writer.close();                                      //调close()后，缓冲区数据写入文件，或调flush()(刷新缓冲区)可使缓冲区数据写入文件
	        } catch (IOException e) {
	        }
	    }

	    BufferedReader reader=null;
	    try {
	      reader=new BufferedReader(new FileReader("e:\\book\\6.txt"));                                  //BufferedReader的构造方法需要的参数类型是FileReader对象
	      String buf;      
	     
	      while((buf=reader.readLine())!=null)                                                     //一次读一行,循环2次 ，newLine（）不算一行读入的字符串，readLine()返回读到的字符串      
	         System.out.println(buf);         
	      
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
 结果：
line 1
line 2

  
 
 */
