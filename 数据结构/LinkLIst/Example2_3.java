package LinkLIst;

import java.util.Scanner;

public class Example2_3 {

	public Example2_3() {
	}

	public static void main(String[] args) throws Exception {
		int n = 5;
	Linklist L = new Linklist();//创建一个空的单链表
		for(int i=0;i<n;i++){
			L.insert(i, i);
		}//注意花括号的位置
			System.out.println("请输入i值");
			int  j = new Scanner(System.in).nextInt();
			if(j>0&&j<=n)
				System.out.println("第"+j+"个元素的直接先驱是"+L.get(j-1));
			else
				System.out.println("第"+j+"个元素的直接先驱不存在");
			
		
	}

}
