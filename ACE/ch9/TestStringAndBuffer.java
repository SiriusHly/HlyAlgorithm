//�μ�chap8 p19
//package ch8;
package ch9;


import java.util.Date;
public class TestStringAndBuffer {
  public static void main(String[] args) {
    String s1="";
    Date d1=new Date();
    for(int i=0;i<100000;i++)                                                           //Ч�ʵͣ�������10000���ռ�
      s1=s1+i;
    Date d2=new Date();
    System.out.println("d2-d1=" + (d2.getTime()-d1.getTime()));

    StringBuffer ss=new StringBuffer();                                                //Ч�ʸߣ�����1�����ռ�
    Date d3=new Date();
    for(int i=0;i<100000;i++)
      ss.append(i);
    String s2=ss.toString();
    Date d4=new Date();
    System.out.println("d4-d3=" + (d4.getTime()-d3.getTime()));
    //System.out.println("s2="+s2);                                     //�����0��--��9999��
  }
}






/*
���������StringBuffer��Ч�ʸߣ�

d2-d1=426
d4-d3=1



*/