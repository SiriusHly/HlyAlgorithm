package Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LSD��������
 *
 * @author louxuezheng 2014��4��2��
 */
public class RadixSortDemo {
 public void radixSort(int[] a) {
  // 1 �������
  int max = a[0];
  for (int i = 1; i < a.length; i++) {
   if (a[i] > max)
    max = a[i];
  }
  // 2 �����������λ��
  int time = 0;
  while (max > 0) {
   max /= 10;
   time++;
  }
  // 3 ����10�����������Ͱ�� ÿ��Ͱ�����ڴ���ƶ�λ����ȵ���
  ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
  for (int i = 0; i < 10; i++) {
   ArrayList<Integer> subqueue = new ArrayList<Integer>();
   queue.add(subqueue);
  }
  // 4 �������е������з�����ռ�
  for (int i = 0; i < time; i++) {
   // ���ݼ����λ��ֵ������Ӧ��Ͱ��
   for (int j = 0; j < a.length; j++) {
    int x = a[j] % (int) Math.pow(10, i + 1)
      / (int) Math.pow(10, i);
    queue.get(x).add(a[j]);
   }
   // ��Ͱ�������ռ�����
   int count = 0;
   for (int k = 0; k < 10; k++) {
    while (queue.get(k).size() > 0) {
     a[count] = queue.get(k).get(0);
     queue.get(k).remove(0);
     count++;
    }
   }
  }
 }

 public static void main(String[] args) {
  RadixSortDemo rsd = new RadixSortDemo();
  int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
    99, 98, 54, 101, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51, 1021,
    2105, 2222 };
  rsd.radixSort(a);
  System.out.println(Arrays.toString(a));
 }
}


