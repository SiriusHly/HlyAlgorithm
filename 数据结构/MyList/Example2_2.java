package MyList;

import java.util.Scanner;

public class Example2_2 {

	public Example2_2() {
	}

	public static void main(String[] args) throws Exception {
		int n=10;
		SqList L = new SqList(80);
		for(int i=0;i<n;i++)
			L.insert(i, i);
		System.out.println("������i��ֵ");
		int i=new Scanner(System.in).nextInt();
		if(0<i&&i<=n){
			System.out.println("��"+i+"��Ԫ�ص�ֱ��ǰ���ǣ�"+L.get(i-1));//�õ�ֱ��ǰ��
		}
		else
			System.out.println("��"+i+"��Ԫ�ص�ֱ��ǰ��������");
		
	}

}
