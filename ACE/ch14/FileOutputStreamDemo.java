package ch14;

import java.io.*;

public class FileOutputStreamDemo{
   public static void main(String[] args){
      try{
          FileOutputStream fileOut=new FileOutputStream("e:\\book\\out.txt");               //·����˫б��           
          byte[] bb="xyz��Һ�".getBytes();                                            //�ַ����������ַ�������ֽ�����
          fileOut.write(bb);                                                    //����д���ļ����ļ��ü��±��򿪿��Կ�������Ϊabc,���ļ������ڽ����ļ������ļ�������д�ļ�
          fileOut.close();
       }catch(FileNotFoundException e){                                        //�����ļ��������쳣,���Բ���
    	   System.out.println("�ļ�������");
       }catch(IOException e){
    	   System.out.println("д�������ǳ���");
       }                                                //����I/O�쳣������Ҫ��
   }    
   
}













/*
�����

(��E:\\bookĿ¼�н����ļ�out.txt���򿪸��ļ���������Ϊabc)
*/