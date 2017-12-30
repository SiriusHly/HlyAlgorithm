package eight_AOV;
/*
 * 17.12.29
 * author:黄良运
 */
import java.util.Stack;

public class MyTopologyofDFS {
	
	static int MAX = Integer.MAX_VALUE;
	static boolean visit[];
	//static String c[] = { "C++", "Java", "Python", "Go", "Php" };
	static String c[] = { "A", "B", "C", "D", "E" };
	static Stack<String> stack = new Stack<String>();
	public static int firstVex(int v,int [][]areas){
		for(int j = 0;j <areas.length;j++)
			if(areas[v][j]!=0&&areas[v][j]<MAX)
				return j;
		return -1;
	}
	
	public static int nextVex(int v,int w,int areas[][]){
		for(int j = w+1;j<areas.length;j++)
			if(areas[v][j]!=0&&areas[v][j]<MAX)
				return j;
		return -1;
	}
	
	public static void topoDFS(int areas[][]){
		visit = new boolean[areas.length];
		for(boolean v:visit)
			v = false;
		for(int k =0 ;k<areas.length;k++)
			if(!visit[k])
				DFS(areas,k);
		for(int i = 0;i<areas.length;i++)
			System.out.print(stack.pop()+" ");
	}
	
	public static  void DFS(int [][]areas,int v){
		visit[v] = true;
		for(int w = firstVex(v, areas);w>=0;w = nextVex(v, w, areas))
			if(!visit[w])
				DFS(areas,w);
		stack.push(c[v]);
	}
	
	public static void main(String[]arvs){
		int areas[][] = { { 0, 1, 1, MAX, MAX }, { MAX, 0, MAX, MAX, MAX }, { MAX, MAX, 0, 1, 1 },
				{ MAX, MAX, MAX, 0, MAX }, { MAX, MAX, MAX, 1, 0 } };
		 //int areas[][] = { { 0, MAX, 1 }, { MAX, 0, MAX }, { MAX, 1, 0 }};
		topoDFS(areas);//A C E D B //B先返回，所以先入栈
	}
}
