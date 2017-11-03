package ch14;

import java.io.*;

public class ReadData {
    public static InputStreamReader inreader=new InputStreamReader(System.in);               //������������ַ����������breader          
    public static BufferedReader breader=new BufferedReader(inreader);                       //�Ӽ��̶�
    
    //���ַ�
    public static char readChar() throws Exception                              
    { String str;
      System.out.println("����һ���ַ�, �Ի��н���!");
      str=breader.readLine();                                        //BufferedReader�з���readLine�ɶ���һ�����ݣ��Իس�����
      return str.charAt(0);                                         //�ַ�������0λ���ַ�
    }
     
    //��int
    public static int readInt() throws Exception
    { String str;
      System.out.println("��������, �Ի��н���!");
      str=breader.readLine();
      //System.out.println(str.length());
      str=str.trim();                                            //ȥ�����˿ո�
      return Integer.parseInt(str);                              //�ַ���ת��������
    } 

    //��String
    public static String readString() throws Exception
    { String str;
      System.out.println("�����ַ���, �Ի��н���!");
      str=breader.readLine();
      return str=str.trim();                                            //�����˿ո�Ҳ�����ַ�����һ���֣��Ͳ���ȥ��
    }

    //��float
    public static float readFloat() throws Exception
    { String str;
      System.out.println("����ʵ��, �Ի��н���!");
      str=breader.readLine();
      str=str.trim();
      return Float.parseFloat(str); 
    }

    //��double
    public static double readDouble() throws Exception
    { String str;
      System.out.println("����ʵ��, �Ի��н���!");
      str=breader.readLine();
      str=str.trim();
      return (double)Float.parseFloat(str); 
    }
   
    //��boolean
    public static boolean readBoolean()throws Exception 
    { String str;
      System.out.println("����true ��false, �Ի��н���!");
      str=breader.readLine();
      str=str.trim();
      return Boolean.parseBoolean(str);
    } 

    public static void main(String args[])throws Exception
    { 
      System.out.println(readChar());                              //�����Ǿ�̬�ģ������п�ֱ���÷�����
      System.out.println(readInt());
      System.out.println(readString());
      System.out.println(readFloat());
      System.out.println(readDouble());
      System.out.println(readBoolean());
   }
}













/*
�����
����һ���ַ����Ի��н�����
a
a
...




*/



