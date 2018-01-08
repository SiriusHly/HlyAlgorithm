package nine_MinimunCostSpanningTree;
/**
 * 
 * @author 黄良运
 * time:17.12.26
 *j
 */
public class MyKruskal {
  
    static char[] c = new char[]{'A','B','C','D','E'}; 
    static int MAX = Integer.MAX_VALUE;

    public static void kruskal(int[][] arcs) {
        //顶点个数
        int num = arcs.length;
        //存放对应顶点所在连通图标识
        int[] flag = new int[num]; 
        int sum = 0, n1 = 0, n2 = 0;
        boolean finished = false;
        while(!finished) {
            int min = Integer.MAX_VALUE;
            //找出所有边中最小值
            for(int i = 0; i < num; i++) {
                for(int j = i+1; j < num; j++) {
                    if(arcs[i][j] > 0 && arcs[i][j] < min){
                        if (flag[i] != flag[j] || (flag[i] == 0 && flag[j] == 0)) {
                            min = arcs[i][j];
                            n1 = i;
                            n2 = j;    
                        }                                            
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                break;
            }
            
            System.out.println(c[n1] + " -> " + c[n2] + " " + min);
            sum += min;
            if(flag[n1] == 0 && flag[n2] == 0){
                flag[n1] = 1;
                flag[n2] = 1;
            }
            else{
                if(flag[n1] == 0)
                    flag[n1] = flag[n2];             
                else
                    flag[n2] = flag[n1];                
            }
            
            for(int i = 0; i < flag.length; i++) {
                if(flag[i] != flag[0]){
                    finished = false;
                    break;
                }
                else{
                    finished = true;
                }
            }
            if(finished) {
                break;
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
   	 int[][] map = new int[][]{
            {0,2,1,4,MAX},
            {2,0,MAX,3,4},
            {1,MAX,0,9,MAX},
            {4,3,9,0,9},
            {MAX,4,MAX,9,0}
            
    };
       kruskal(map);
   }
}