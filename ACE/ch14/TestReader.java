package ch14;

import java.io.*;

public class TestReader{
  public static void main(String[] args){
    int Num;
    String name[],classes[];                                                //�����ַ�������

    //�����ַ�����������
    InputStreamReader stdin=new InputStreamReader(System.in); 
    BufferedReader bufIn=new BufferedReader(stdin);                         // �����ַ����뻺�������Ӽ��̶�

    try	{
      System.out.println("��ʼ����ѧ����Ϣ");
      System.out.print("������ѧ��������: ");
      Num=Integer.parseInt(bufIn.readLine());                              // ����ȡ��ѧ���������ַ����ͣ�ת��Ϊ������ûȥ���˿ո�Ӧ��ȥ���˿ո����пո���תΪ������
      name=new String[Num];                                                //�����������飬�ַ�������name���±����������
      classes=new String[Num];                                             //����༶���飬�ַ�������classes���±�����Ű�ţ��±�Ϊi��������name[i]���ŷ�classes[i]

      for(int i=0;i<Num;i++) {                                             // ���ѧ����Ϣ������
        System.out.println((i+1)+"��");                                    //Ϊ�����Ѻò���ʾ0��
        System.out.print("����: ");
        name[i]=bufIn.readLine();                                         //�Ӽ��̶����i��ѧ�������������±߱���Name[i-1]
        System.out.print("�༶: ");                                      //�Ӽ��̶����i����ţ������±߱���classes[i-1]�������i��ѧ�����ڵİ��
        classes[i]=bufIn.readLine();
      }

      System.out.println("�����ѧ����Ϣ����!\n");
      System.out.println("��ʼѧ����Ϣ��ʾ");
      for(int i=0;i<Num;i++) {                                        // ���ѧ����Ϣ����ʾ
        System.out.print((i+1)+"�� ");
        System.out.print("����: "+name[i]);
        System.out.println(" �༶: "+classes[i]);
      }

      stdin.close();                                                // �ر�������
      bufIn.close();                                                // �ͷŻ�����
    }//ends of try
    catch(IOException e) {
      System.out.println("����I/O�쳣!");
    }
  }
}


/*
����� ������������ʱ���λ����Ҫ�����λ�ã�eclipse����ʱ�������ˣ�
 
��ʼ����ѧ����Ϣ
������ѧ��������: 3
1��
����: ��
�༶: 1
2��
����: ��
�༶: 2
3��
����: ��
�༶: 3
�����ѧ����Ϣ����!

��ʼѧ����Ϣ��ʾ
1�� ����: �� �༶: 1
2�� ����: �� �༶: 2
3�� ����: �� �༶: 3 
 
 
 */
