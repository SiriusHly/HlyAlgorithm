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
		System.out.println("请输入i的值");
		int i=new Scanner(System.in).nextInt();
		if(0<i&&i<=n){
			System.out.println("第"+i+"个元素的直接前驱是："+L.get(i-1));//得到直接前驱
		}
		else
			System.out.println("第"+i+"个元素的直接前驱不存在");
		
	}

}
