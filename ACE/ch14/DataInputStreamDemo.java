package ch14;

import java.io.*;

public class DataInputStreamDemo {
  public static void main(String[] args) {
    DataInputStream dataInput=null;

    try {
      dataInput=new DataInputStream(new FileInputStream("e:\\book\\1.txt"));

      int intData = dataInput.readInt();                                            //读的顺序要与写的顺序一致，1个整型，1个布尔型
      boolean boolData = dataInput.readBoolean(); 
      
      System.out.println("intData = " + intData);
      System.out.println("boolData = " + boolData);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (dataInput!=null){
        try {
          dataInput.close();
        } catch (IOException e) {
        }
      }
    }
  }
}


/*
结果：
intData=1
boolData=true
*/