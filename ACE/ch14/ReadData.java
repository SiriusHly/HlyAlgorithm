package ch14;

import java.io.*;

public class ReadData {
    public static InputStreamReader inreader=new InputStreamReader(System.in);               //建立带缓冲的字符流输入对象breader          
    public static BufferedReader breader=new BufferedReader(inreader);                       //从键盘读
    
    //读字符
    public static char readChar() throws Exception                              
    { String str;
      System.out.println("输入一个字符, 以换行结束!");
      str=breader.readLine();                                        //BufferedReader中方法readLine可读入一行数据，以回车结束
      return str.charAt(0);                                         //字符串返回0位置字符
    }
     
    //读int
    public static int readInt() throws Exception
    { String str;
      System.out.println("输入整数, 以换行结束!");
      str=breader.readLine();
      //System.out.println(str.length());
      str=str.trim();                                            //去掉两端空格
      return Integer.parseInt(str);                              //字符串转换成整型
    } 

    //读String
    public static String readString() throws Exception
    { String str;
      System.out.println("输入字符串, 以换行结束!");
      str=breader.readLine();
      return str=str.trim();                                            //若两端空格也算作字符串的一部分，就不用去掉
    }

    //读float
    public static float readFloat() throws Exception
    { String str;
      System.out.println("输入实数, 以换行结束!");
      str=breader.readLine();
      str=str.trim();
      return Float.parseFloat(str); 
    }

    //读double
    public static double readDouble() throws Exception
    { String str;
      System.out.println("输入实数, 以换行结束!");
      str=breader.readLine();
      str=str.trim();
      return (double)Float.parseFloat(str); 
    }
   
    //读boolean
    public static boolean readBoolean()throws Exception 
    { String str;
      System.out.println("输入true 或false, 以换行结束!");
      str=breader.readLine();
      str=str.trim();
      return Boolean.parseBoolean(str);
    } 

    public static void main(String args[])throws Exception
    { 
      System.out.println(readChar());                              //方法是静态的，本类中可直接用方法名
      System.out.println(readInt());
      System.out.println(readString());
      System.out.println(readFloat());
      System.out.println(readDouble());
      System.out.println(readBoolean());
   }
}













/*
结果：
输入一个字符，以换行结束！
a
a
...




*/



