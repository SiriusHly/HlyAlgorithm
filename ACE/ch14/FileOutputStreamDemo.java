package ch14;

import java.io.*;

public class FileOutputStreamDemo{
   public static void main(String[] args){
      try{
          FileOutputStream fileOut=new FileOutputStream("e:\\book\\out.txt");               //路径用双斜杠           
          byte[] bb="xyz大家好".getBytes();                                            //字符串方法，字符串变成字节数组
          fileOut.write(bb);                                                    //数组写入文件，文件用记事本打开可以看到内容为abc,若文件不存在建立文件，若文件存在重写文件
          fileOut.close();
       }catch(FileNotFoundException e){                                        //捕获文件不存在异常,可以不用
    	   System.out.println("文件不存在");
       }catch(IOException e){
    	   System.out.println("写入数据是出错");
       }                                                //捕获I/O异常，必须要用
   }    
   
}













/*
结果：

(在E:\\book目录中建立文件out.txt，打开该文件，其内容为abc)
*/