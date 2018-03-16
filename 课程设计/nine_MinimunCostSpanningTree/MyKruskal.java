package nine_MinimunCostSpanningTree;

import java.util.Arrays;

/**
 * 
 * @author 黄良运
 * time:17.12.26
 *j
 */
public class MyKruskal {
  
	static String[] c = new String[] { "博文楼","科技馆","逸夫楼","信息楼","图书馆" };
    static int MAX = Integer.MAX_VALUE;

    public static void kruskal(int[][] areas) {
        //顶点个数
        int num = areas.length;
        //存放对应顶点所在连通图标识
        boolean [] flag = new boolean[num]; 
        Arrays.fill(flag, false);
        int sum = 0, n = 0, m = 0;
        boolean finished = false;
        while(!finished) {
            int min = Integer.MAX_VALUE;
            //找出所有边中最小值
            for(int i = 0; i < num; i++) {
                for(int j = i+1; j < num; j++) {
                    if(areas[i][j] > 0 && areas[i][j] < min){
                        if (flag[i] != flag[j] || (flag[i] == false && flag[j] == false)) {
                            min = areas[i][j];
                            n = i;
                            m = j;    
                        }                                            
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                break;
            }
            
            System.out.println(c[n] + " ---> " + c[m] + " " + min);
            sum += min;
            if(flag[n] == false && flag[m] == false){
                flag[n] = true;
                flag[m] = true;
            }
            else{
                if(flag[n] == false)
                    flag[n] = flag[m];             
                else
                    flag[m] = flag[n];                
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
        System.out.println("总距离"+sum);
    }
    public static void main(String[] args) {
   	 int[][] areas = new int[][]{
            {0,2,1,4,MAX},
            {2,0,MAX,3,4},
            {1,MAX,0,9,MAX},
            {4,3,9,0,9},
            {MAX,4,MAX,9,0}
            
    };
       kruskal(areas);
   }
}