package ch14;

import java.io.*;

public class DataOutputStreamDemo {
  public static void main(String[] args) {
    DataOutputStream dataOutput = null;                                              //在finally中用到dataOutput，声明需要放在try外面

    try {
     
      dataOutput = new DataOutputStream(new FileOutputStream("e:\\book\\1.txt"));            //路径用双斜杠,用记事本打开看不到内容（不可读），但文件大小>0字节，若文件存在覆盖原文件

      dataOutput.writeInt(1);                                      //写整型
      dataOutput.writeBoolean(true);                              // 写布尔类型
      
      dataOutput.close();                                      //及时关文件

    } catch (FileNotFoundException e) {                        //文件未找到异常
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {                                  //读写异常，如硬件故障
      e.printStackTrace();
    } finally {                                                        //如果实例化对象dataOutput，即文件存在则关文件
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
结果：

（在e:\\book目录中建立文件1.txt）

*/