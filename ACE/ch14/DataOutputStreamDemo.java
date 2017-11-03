package ch14;

import java.io.*;

public class DataOutputStreamDemo {
  public static void main(String[] args) {
    DataOutputStream dataOutput = null;                                              //��finally���õ�dataOutput��������Ҫ����try����

    try {
     
      dataOutput = new DataOutputStream(new FileOutputStream("e:\\book\\1.txt"));            //·����˫б��,�ü��±��򿪿��������ݣ����ɶ��������ļ���С>0�ֽڣ����ļ����ڸ���ԭ�ļ�

      dataOutput.writeInt(1);                                      //д����
      dataOutput.writeBoolean(true);                              // д��������
      
      dataOutput.close();                                      //��ʱ���ļ�

    } catch (FileNotFoundException e) {                        //�ļ�δ�ҵ��쳣
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {                                  //��д�쳣����Ӳ������
      e.printStackTrace();
    } finally {                                                        //���ʵ��������dataOutput�����ļ���������ļ�
      if (dataOutput != null) {
        try {
          dataOutput.close();
        } catch (IOException e) {
        }
      }
    }
  }
}




/*
�����

����e:\\bookĿ¼�н����ļ�1.txt��

*/