package ten_ShortestPath;

import java.util.Scanner;

/*
 * time:18.1.1
 * author :黄良运
 * 
 */
public class MyFloyd {
	static String c [] = {"A","B","C","D"};
	private static  boolean [][][]P;
	private static int [][]D;
	public final static int MAX = Integer.MAX_VALUE;
	
	public static  void Floyd(int [][]areas){
		int num = areas.length;
		P = new boolean[num][num][num];
		D = new int [num][num];
		for(int i=0;i<num;i++){//各对结点1之间初始化已知路径及距离
			for(int j =0 ;j<num;j++){
				D[i][j] = areas[i][j];
				for(int k = 0;k<num;k++){
					P[i][j][k] = false;
				}
				if(D[i][j]<MAX){
					P[i][j][i] = true;
					P[i][j][j] = true;
				}
			}
		}
		for(int j =0 ;j<num;j++)
			for(int i =0 ;i<num;i++)
				for(int k =0 ;k<num;k++)
		if(D[i][j]<MAX&&D[j][k]<MAX&&D[i][j]+D[j][k]<D[i][k]){
			D[i][k] = D[i][j]+D[j][k];
			for(int f = 0;f<num;f++){
				P[i][k][f] = P[i][j][f]||P[j][k][f];
			}
		}
	}
	public static void  display(int [][]D){
		for(int i = 0;i<D.length;i++){
			for(int j = 0;j<D.length;j++)
				System.out.print(c[i]+"到"+c[j]+"的最短路径为: "+D[i][j]+"    ");
		System.out.println();
		}
	}
	public static int  search(String str){
		for(int k =0 ;k<c.length;k++)
			if(c[k].equals(str))
				return k;
		return -1;
				
	}
	public static void main(String[]arvs){
		Scanner in = new Scanner(System.in);
		int areas [][] = {
				{0,1,5,9},
				{1,0,MAX,2},
				{5,MAX,0,8},
				{9,2,8,0}
		};
		Floyd(areas);
		display(D);
		//System.out.println("请输入要查询的两个城市名称：");
		System.out.println("这两座城市之间的最短距离为："+D[search("B")][search("C")]);
		while(in.hasNext()){
		String n = in.next();
		String m = in.next();
		System.out.println("这两座城市之间的最短距离为："+D[search(n)][search(m)]);
		}
		in.close();
	}

}
