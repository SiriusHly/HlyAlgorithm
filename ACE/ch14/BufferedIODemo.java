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
	    BufferedWriter writer = null;                                                   //��ʼ��
	    try {
	      writer = new BufferedWriter(new FileWriter("e:\\book\\6.txt"));                    //BufferedWriter�Ĺ��췽����Ҫ�Ĳ���������FileWriter����     
	     
	      writer.write("line 1\n");                                                  //д�ļ���ͷд�����ļ�ԭ�������ݣ�ԭ���ݱ����ǣ��ü��±��򿪿ɶ�,���±��￴����������һ�У��л��У������в���д���ļ����ַ�����
	      writer.newLine();                                                        //����һ�У����У�
	      writer.write("line 2");
	      writer.newLine();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      if (writer!=null)
	        try {
	          writer.close();                                      //��close()�󣬻���������д���ļ������flush()(ˢ�»�����)��ʹ����������д���ļ�
	        } catch (IOException e) {
	        }
	    }

	    BufferedReader reader=null;
	    try {
	      reader=new BufferedReader(new FileReader("e:\\book\\6.txt"));                                  //BufferedReader�Ĺ��췽����Ҫ�Ĳ���������FileReader����
	      String buf;      
	     
	      while((buf=reader.readLine())!=null)                                                     //һ�ζ�һ��,ѭ��2�� ��newLine��������һ�ж�����ַ�����readLine()���ض������ַ���      
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
 �����
line 1
line 2

  
 
 */
