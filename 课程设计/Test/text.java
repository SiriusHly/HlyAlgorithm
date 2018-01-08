package Test;

public class text {
	static final int MAX = 10000;
	public static int[] Dijsktra(int[][]weight,int start){
        int length = weight.length;
        int[] shortPath = new int[length];//��Ŵ�start�����������̾���
        shortPath[start] = 0;//start��������ľ������Ϊ0
        String path[] = new String[length];//��Ŵ�start�㵽��������·�����ַ�����ʾ
        for(int i=0;i<length;i++){
            path[i] = start+"->"+i;
        }
        int visited[] = new int[length];//��ǵ�ǰ�ö�������·���Ƿ��Ѿ������1��ʾ�Ѿ����
        visited[start] = 1;//start�����̾����Ѿ����
        for(int count = 1;count<length;count++){
            int k=-1;
            int dmin = Integer.MAX_VALUE;
            for(int i=0;i<length;i++){
                if(visited[i]==0 && weight[start][i]<dmin){
                    dmin = weight[start][i];
                    k=i;
                }
            }
            //ѡ��һ������start�����δ��ǵĶ���     ����ѡ���Ķ�����Ϊ��������·�����ҵ�start�����·��Ϊdmin��
            shortPath[k] = dmin;
            visited[k] = 1;
            //��kΪ�м�㣬������start��δ���ʸ���ľ���
            for(int i=0;i<length;i++){
                if(visited[i]==0 && weight[start][k]+weight[k][i]<weight[start][i]){
                    weight[start][i] = weight[start][k]+weight[k][i];
                    path[i] = path[k]+"->"+i;
                }
            }
        }
        for(int i=0;i<length;i++){
            System.out.println("��"+start+"������"+i+"�����·��Ϊ��"+path[i]+"="+shortPath[i]);
        }
        return shortPath;
         
    }
	public static void main(String[] args) {
        int[][] weight = { { 0, 1, 25, 9 }, { 1, 0, MAX, 2 }, { 25, MAX, 0, 18 }, { 9, 2, 18, 0 } };
        int start = 0;
        int[] dijsktra = Dijsktra(weight,start);
    }
}
