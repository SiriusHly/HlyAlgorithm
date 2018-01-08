package one_����;

import java.util.ArrayList;

/*
 * 2017.12.9
 * author ������
 * �����㷨��˼��
 */
public class MySort<AnyType extends Comparable<? super AnyType>> {
	// 1.ֱ�Ӳ�������
	AnyType[] Arr;
	public AnyType[] InsertSort(AnyType[] Arr) {
		int i, j;
		AnyType temp;
		for (i = 0; i < Arr.length; i++) {
			temp = Arr[i];
			for (j = i - 1; j >= 0 && temp.compareTo(Arr[j]) < 0; j--)
				Arr[j + 1] = Arr[j];//j+1=i=temp
			Arr[j + 1] = temp;//j--�ˣ�����Ҫ�ӣ�j=i-1,temp=i,  i=j+1=temp
			//display(Arr);
		}
		return Arr;
	}

	// 2.ֱ�Ӳ�������������ڣ�ÿһ�Σ�ÿһ�ˣ�ÿһ����һֱ��ǰ�Ƚϣ���ǰ����
	public AnyType[] InsertSortWithGuard(AnyType[] Arr) {
		int i, j;
		for (i = 2; i < Arr.length; i++) {//i����2��ʼ
			Arr[0] = Arr[i];
			for (j = i - 1; Arr[0].compareTo(Arr[j]) < 0; j--){//j=i-1,j��a[0]��1
				Arr[j + 1] = Arr[j];
			}
			Arr[j + 1] = Arr[0];
			
		}
		//display(Arr);
		return Arr;
	}

	// 3.shell����
	public void shellSort(int[] d, AnyType[] Arr) {
		int i, j;
		AnyType temp;
		for (int k = 0; k < d.length; k++) {
			int dk = d[k];
			for (i = dk; i < Arr.length; i++) {
				temp = Arr[i];
				for (j = i - dk; j >= 0 && temp.compareTo(Arr[j]) < 0; j -= dk) {
					Arr[j + dk] = Arr[j];
				}
				Arr[j + dk] = temp;// forѭ����βj-=dk�ˣ����Ҫ��,j=i-1;i=temp;j+1=temp   5 2 6 4
			}
			//display(Arr);
		}
	}

	// 4.����8 one_����
	public AnyType[] bubbleSort(AnyType[] Arr) {
		int i, j;
		boolean flag = true;
		AnyType temp;
		for (i = 1; i < Arr.length && flag; i++) {
			flag = false;//�����һ�˲�������ԶΪfalseִֻ��һ��
			for (j = 0; j < Arr.length - i; j++) {
				if (Arr[j].compareTo(Arr[j + 1]) > 0) {
					temp = Arr[j];
					Arr[j] = Arr[j + 1];
					Arr[j + 1] = temp;
					flag = true;
				}
			}
		}
		return Arr;
	}

	// ��������һ�˿��������㷨
	public int partitionSort(int low, int high,AnyType[]Arr) {
		AnyType pivot = Arr[low]; // ��һ����¼��Ϊ֧���¼
		while (low < high) {
			while (low < high && pivot.compareTo(Arr[high]) <= 0) {//���ұߵ�����������ʱ��j���ƣ�ֱ���ҵ���pivotС��
				high--;
			}
			if (low < high) {
				Arr[low] = Arr[high];//�Ҳ��baseС�������浽Arr[0]��
				low++;
			}
			while (low < high && pivot.compareTo(Arr[low]) > 0) {
				low++;
			}
			if (low < high) {
				Arr[high] = Arr[low];//����base��������浽Arr[3]�У�j--����λ��
				high--;
			}
		}
		Arr[low] = pivot;//base�������������
		return low;//��������base��������±�
	}
	// 5.��������ݹ��㷨,����С�����Ҵ�
	public AnyType[] qSort(int low, int high,AnyType[]Arr) {
		if (low < high) {
			int pivotloc = partitionSort(low, high,Arr);
			qSort(low, pivotloc - 1,Arr);
			qSort(pivotloc + 1, high,Arr);
		}
		return Arr;
	}

	// 6.ֱ��ѡ������
	//n����¼���ҳ���С�ļ�¼���һ����¼������n-1���ڶ������Դ����ƣ��Ƚϼ�
	public AnyType[] selectSort(AnyType[] Arr) {
		AnyType temp;
		for (int i = 0; i < Arr.length - 1; i++) {// n-1������
			// ÿ�˴�r[i]��ʼ����������Ѱ����С�ؼ���ֵ�ü�¼
			int min = i;// ���i����¼�Ĺؼ���ֵ��С
			for (int j = i + 1; j < Arr.length; j++) {
				if (Arr[j].compareTo(Arr[min]) < 0) {
					min = j;
				}
			}
			if (min != i) {
				temp = Arr[i];
				Arr[i] = Arr[min];
				Arr[min] = temp;
			}

		}
		return Arr;
	}

	// 7.ɸѡ�������������㷨
	// ����lowΪ����������������С���ѣ�low����high�ֱ������е��Ͻ���½�
	public void sift(int low, int high,AnyType[]Arr) {
		int i = low;
		int j = 2 * i + 1;
		AnyType temp = Arr[i];
		while (j < high) {
			if (j < high - 1 && Arr[j].compareTo(Arr[j + 1]) > 0) {//ѡ����С����������
				j++;
			}
			if (temp.compareTo(Arr[j]) > 0) {//������������С�ͻ���ȥ
				Arr[i] = Arr[j];
				i = j;//ÿһ��j��i��j��ʼ
				j = 2 * i + 1;
			} else {
				j = high + 1;
			}
		}
		Arr[i] = temp;
	}

	// 7.�������㷨
	public AnyType[] heapSort(AnyType Arr[]) {
		int n = Arr.length;
		AnyType temp;
		for (int i = n / 2 - 1; i >= 0; i--) {//��Ҷ�ӽ��n/2-1��ʼ�����ĸ���㣬�õ�һ����ʼ��
			sift(i, n,Arr);
		}
		for (int i = n - 1; i > 0; i--) {
			temp = Arr[0];
			Arr[0] = Arr[i];//���һ���͵�һ������
			Arr[i] = temp;
			sift(0, i,Arr);
		}
		return Arr;
	}

	//�������ڵ��������еĹ鲢
	public void merge(AnyType[] r,AnyType[] order,int h,int m,int t){//h->m,m+1->t
		int i = h,j=m+1,k=h;
		while(i<=m&&j<=t){//�������������й鲢��order��
			if(r[i].compareTo(r[j])<=0){//��Сֵ���Ƶ�order��
				order[k++] = r[i++];
			}
			else{
				order[k++] = r[j++];
			}
			while(i<=m){
				order[k++] = r[i++];
			}
			while(j<=t){
				order[k++]=r[j++];
			}
		}
	}
	
	//һ�˹鲢����
	public void mergepass(AnyType [] r, AnyType [] order,int s , int n){//s,�����еĳ���
		int p = 0;//p Ϊÿһ�Դ��ϲ���ĵ�һ��Ԫ�ص��±��ֵΪ0
		while(p+2*s-1<n-1){//�����鲢���Ⱦ�Ϊs�������
			merge(r,order,p,p+s-1,p+2*s-1);
			p+=2*s;//����ƣ�����������
		}
		if(p+s-1<n-1){
			merge(r,order,p,p+s-1,n-1);
		} else{
			for(int i = p;i <= n-1;i++){
				order[i] = r[i];
			}
		}
		
	}
	
	//��·�鲢�����㷨
	public void mergeSort(AnyType [] Arr){
		int s =1;
		int n =Arr.length;
		AnyType [] temp = (AnyType[]) new Integer[n];
		while(s<n){
			mergepass(Arr, temp, s, n);//һ�˹鲢���򣬽�r�����и������й鲢��temp��
			s*=2;//�����г��ȼӱ�
			mergepass(temp, Arr, s, n);
			s*=2;
		}
	}
	//��ʽ��������
	public ArrayList<Integer> RadixSort(ArrayList<Integer> Arr,int d){
		ArrayList<Integer> []A = new ArrayList[10]; 
		for(int w =0;w<A.length;w++)
			A[w]= new ArrayList<>();
		for(int i = 0;i<d;i++){
			for(int w =0;w<A.length;w++)
				A[w].clear();
			for(int k=0;k<Arr.size();k++){
				int j =(int) (Arr.get(k)/Math.pow(10, i)%10);
				A[j].add(Arr.get(k));
			}
			Arr.clear();
			for(int f = 0;f<A.length;f++){
				Arr.addAll(A[f]);
			}
		}
		return Arr;
		
	}

	private void display(AnyType[] Arr) {
		for (int i = 0; i < Arr.length; i++)
			System.out.print(Arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		MySort<Integer> mySort = new MySort<Integer>();
		int[] d = { 2, 1 };
		Integer[] Arr = new Integer[30000];
		//Integer[] Arr = {5, 4, 6, 2};
		Integer[] Arr2 = {5, 4, 6, 2, 9, 7, 4, 5, 2, 33, 44, 77, 88};
		ArrayList<Integer> Arr3 = new ArrayList<Integer>();
		/*Arr3.add(51);
		Arr3.add(24);
		Arr3.add(36);
		*/
		for(int i=0;i<30000;i++)
			Arr3.add((int)(Math.random()*30000+1));
		//Arr3 = (ArrayList<Integer>) Arrays.asList(Arr2);

		for(int i = 0;i<30000;i++)
			Arr[i] = (int)(Math.random()*30000+1);//1-100
		int begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		Arr3 = mySort.RadixSort(Arr3, 5);//28-31
		//mySort.mergeSort(Arr);//6-27
		//mySort.shellSort(d, Arr);//1149=1443
		//mySort.InsertSort(Arr);//1558-2700
		//mySort.bubbleSort(Arr);//10318
		//mySort.selectSort(Arr);//1839-2305
		//mySort.qSort(0, 29999,Arr);//16-24
		//mySort.heapSort(Arr);//18-32
		//mySort.display(Arr);
		//mySort.InsertSortWithGuard(Arr);//1273-1368
		System.out.println("����ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		/*for(int i:Arr3)
			System.out.print(i+" ");*/
		/*begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.mergeSort(Arr);//6-27
		System.out.println("�鲢������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.shellSort(d, Arr);//1149=1443
		System.out.println("shell������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.InsertSort(Arr);//1558-2700
		System.out.println("����������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.bubbleSort(Arr);//10318
		System.out.println("ð��������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.selectSort(Arr);//1839-2305
		System.out.println("ѡ��������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.qSort(0, 30000,Arr);//16-24
		System.out.println("����������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.heapSort(Arr);//18-32
		System.out.println("��������ʱ��"+(int) (System.currentTimeMillis()-begin)+"����");*/
		
		
	}

}
