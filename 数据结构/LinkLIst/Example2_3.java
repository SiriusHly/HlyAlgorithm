package LinkLIst;

import java.util.Scanner;

public class Example2_3 {

	public Example2_3() {
	}

	public static void main(String[] args) throws Exception {
		int n = 5;
	Linklist L = new Linklist();//����һ���յĵ�����
		for(int i=0;i<n;i++){
			L.insert(i, i);
		}//ע�⻨���ŵ�λ��
			System.out.println("������iֵ");
			int  j = new Scanner(System.in).nextInt();
			if(j>0&&j<=n)
				System.out.println("��"+j+"��Ԫ�ص�ֱ��������"+L.get(j-1));
			else
				System.out.println("��"+j+"��Ԫ�ص�ֱ������������");
			
		
	}

}
