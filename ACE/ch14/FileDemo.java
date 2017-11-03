package ch14;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {
  public static void main(String[] args) {
    String path = File.separator + "a" + File.separator + "b.txt";                 //��̬��Ա����ͨ������ʹ��
    System.out.println("path="+path);  
    File file = new File(path);
    System.out.println("file.absolutePath="+file.getAbsolutePath());                  //��ȡ�ļ��ľ���·��E:\a\b.txt����Ҫ�ֶ���Ŀ¼a  

   //File file = new File("e:\\book\\4.txt");                                         //\��ת���ַ�Ϊ\\
   //System.out.println("file.absolutePath="+file.getAbsolutePath()); 
   
    //���濪ʼ����ļ��Ƿ����
    if (file.exists()) {                                    //�ж��ļ��Ƿ���ڣ�ԭ��(����ǰ)�����ڷ���false��ִ��һ�α�������ļ�����(����)����true
      System.out.println("file exists");
    } else {
      System.out.println("file not exists");
    }

    //���濪ʼ�������ļ�
    boolean success;
    try {
      success = file.createNewFile();                   //�����ڴ��ļ�ʱ������������true;����ʱ������������ false
      if (success) {
        System.out.println("file created");
      } else {
        System.out.println("file already exists");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    //���濪ʼ�õ��ļ��Ĵ�С
    long fileLength = file.length();
    System.out.println("fileLength = " + fileLength);

    //���濪ʼɾ���ļ�
 /*   success = file.delete();                                      //ɾ��e:\a\b.txt
    if (success) {
      System.out.println("file deleted");
    } else {
      System.out.println("file delete failed");
    }
*/

    //���濪ʼ���ļ�����
/*
 success = file.renameTo(new File("e:\\book\\destFile.txt"));                 //e:\a\b.txt�ļ�������ʱ�Դ��������ļ��ŵ�e:\book�ļ��У�����true���ļ��������൱���ļ��ƶ������ļ�����ʱ����false
 //success = file.renameTo(new File("e:\\a\\destFile.txt"));                   //e:\a\b.txt�ļ�����ʱ�Դ���Ϊԭ���ļ�����������true
    if (success) {
      System.out.println("file renamed");
    } else {
      System.out.println("file rename failed");
    }
    */

    //���濪ʼ�õ��ļ��ϴ��޸�ʱ��
    long lastModifiedTime = file.lastModified();
    System.out.println("lastModifiedTime = " + new Date(lastModifiedTime));

  }
}





/*
�����

path=\a\b.txt
file.absolutePath=E:\a\b.txt
file not exists
file created
fileLength=0
file rename failed
lastModifiedTime = Sun May 22 16:32:24 CST 2016



���(������һ��)��
path=\a\b.txt
file exists
file already exists
fileLength=0
file rename failed
lastModifiedTime = Sun May 22 16:32:24 CST 2016
*/

