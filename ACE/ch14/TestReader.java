package ch14;

import java.io.*;

public class TestReader{
  public static void main(String[] args){
    int Num;
    String name[],classes[];                                                //声明字符串数组

    //定义字符输入流对象
    InputStreamReader stdin=new InputStreamReader(System.in); 
    BufferedReader bufIn=new BufferedReader(stdin);                         // 定义字符读入缓冲区，从键盘读

    try	{
      System.out.println("开始读入学生信息");
      System.out.print("请输入学生的人数: ");
      Num=Integer.parseInt(bufIn.readLine());                              // 将读取的学生人数（字符串型）转换为整数，没去两端空格（应该去两端空格，若有空格不能转为整数）
      name=new String[Num];                                                //定义姓名数组，字符串数组name的下标变量放姓名
      classes=new String[Num];                                             //定义班级数组，字符串数组classes的下标变量放班号，下标为i的姓名放name[i]其班号放classes[i]

      for(int i=0;i<Num;i++) {                                             // 完成学生信息的输入
        System.out.println((i+1)+"号");                                    //为界面友好不显示0号
        System.out.print("姓名: ");
        name[i]=bufIn.readLine();                                         //从键盘读入第i个学生姓名，放入下边变量Name[i-1]
        System.out.print("班级: ");                                      //从键盘读入第i个班号，放入下边变量classes[i-1]，读入第i个学生所在的班号
        classes[i]=bufIn.readLine();
      }

      System.out.println("已完成学生信息输入!\n");
      System.out.println("开始学生信息显示");
      for(int i=0;i<Num;i++) {                                        // 完成学生信息的显示
        System.out.print((i+1)+"号 ");
        System.out.print("姓名: "+name[i]);
        System.out.println(" 班级: "+classes[i]);
      }

      stdin.close();                                                // 关闭输入流
      bufIn.close();                                                // 释放缓冲区
    }//ends of try
    catch(IOException e) {
      System.out.println("发生I/O异常!");
    }
  }
}


/*
结果： （命令行运行时光标位置在要输入的位置，eclipse运行时光标在左端）
 
开始读入学生信息
请输入学生的人数: 3
1号
姓名: 李
班级: 1
2号
姓名: 王
班级: 2
3号
姓名: 张
班级: 3
已完成学生信息输入!

开始学生信息显示
1号 姓名: 李 班级: 1
2号 姓名: 王 班级: 2
3号 姓名: 张 班级: 3 
 
 
 */
