package ch14;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {
  public static void main(String[] args) {
    String path = File.separator + "a" + File.separator + "b.txt";                 //静态成员变量通过类名使用
    System.out.println("path="+path);  
    File file = new File(path);
    System.out.println("file.absolutePath="+file.getAbsolutePath());                  //获取文件的绝对路径E:\a\b.txt，需要手动建目录a  

   //File file = new File("e:\\book\\4.txt");                                         //\的转义字符为\\
   //System.out.println("file.absolutePath="+file.getAbsolutePath()); 
   
    //下面开始检查文件是否存在
    if (file.exists()) {                                    //判断文件是否存在，原来(创建前)不存在返回false，执行一次本程序后文件存在(创建)返回true
      System.out.println("file exists");
    } else {
      System.out.println("file not exists");
    }

    //下面开始创建新文件
    boolean success;
    try {
      success = file.createNewFile();                   //不存在此文件时，创建并返回true;存在时不创建，返回 false
      if (success) {
        System.out.println("file created");
      } else {
        System.out.println("file already exists");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    //下面开始得到文件的大小
    long fileLength = file.length();
    System.out.println("fileLength = " + fileLength);

    //下面开始删除文件
 /*   success = file.delete();                                      //删除e:\a\b.txt
    if (success) {
      System.out.println("file deleted");
    } else {
      System.out.println("file delete failed");
    }
*/

    //下面开始对文件改名
/*
 success = file.renameTo(new File("e:\\book\\destFile.txt"));                 //e:\a\b.txt文件不存在时以此名命名文件放到e:\book文件夹，返回true（文件改名并相当于文件移动）；文件存在时返回false
 //success = file.renameTo(new File("e:\\a\\destFile.txt"));                   //e:\a\b.txt文件存在时以此名为原来文件改名，返回true
    if (success) {
      System.out.println("file renamed");
    } else {
      System.out.println("file rename failed");
    }
    */

    //下面开始得到文件上次修改时间
    long lastModifiedTime = file.lastModified();
    System.out.println("lastModifiedTime = " + new Date(lastModifiedTime));

  }
}





/*
结果：

path=\a\b.txt
file.absolutePath=E:\a\b.txt
file not exists
file created
fileLength=0
file rename failed
lastModifiedTime = Sun May 22 16:32:24 CST 2016



结果(再运行一次)：
path=\a\b.txt
file exists
file already exists
fileLength=0
file rename failed
lastModifiedTime = Sun May 22 16:32:24 CST 2016
*/

