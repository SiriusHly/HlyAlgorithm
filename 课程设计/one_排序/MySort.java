package one_排序;

import java.util.ArrayList;

/*
 * 2017.12.9
 * author 黄良运
 * 排序算法及思想
 */
public class MySort<AnyType extends Comparable<? super AnyType>> {
	// 1.直接插入排序
	AnyType[] Arr;
	public AnyType[] InsertSort(AnyType[] Arr) {
		int i, j;
		AnyType temp;
		for (i = 0; i < Arr.length; i++) {
			temp = Arr[i];
			for (j = i - 1; j >= 0 && temp.compareTo(Arr[j]) < 0; j--)
				Arr[j + 1] = Arr[j];//j+1=i=temp
			Arr[j + 1] = temp;//j--了，所以要加；j=i-1,temp=i,  i=j+1=temp
			//display(Arr);
		}
		return Arr;
	}

	// 2.直接插入排序带监视哨，每一段，每一趟，每一个数一直往前比较，往前插入
	public AnyType[] InsertSortWithGuard(AnyType[] Arr) {
		int i, j;
		for (i = 2; i < Arr.length; i++) {//i可以2开始
			Arr[0] = Arr[i];
			for (j = i - 1; Arr[0].compareTo(Arr[j]) < 0; j--){//j=i-1,j和a[0]差1
				Arr[j + 1] = Arr[j];
			}
			Arr[j + 1] = Arr[0];
			
		}
		//display(Arr);
		return Arr;
	}

	// 3.shell排序
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
				Arr[j + dk] = temp;// for循环结尾j-=dk了，因此要加,j=i-1;i=temp;j+1=temp   5 2 6 4
			}
			//display(Arr);
		}
	}

	// 4.交换8 one_排序
	public AnyType[] bubbleSort(AnyType[] Arr) {
		int i, j;
		boolean flag = true;
		AnyType temp;
		for (i = 1; i < Arr.length && flag; i++) {
			flag = false;//如果第一趟不交换永远为false只执行一次
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

	// 快速排序，一趟快速排序算法
	public int partitionSort(int low, int high,AnyType[]Arr) {
		AnyType pivot = Arr[low]; // 第一个记录作为支点记录
		while (low < high) {
			while (low < high && pivot.compareTo(Arr[high]) <= 0) {//当右边的数大于枢轴时，j左移，直到找到比pivot小的
				high--;
			}
			if (low < high) {
				Arr[low] = Arr[high];//右侧比base小的数保存到Arr[0]中
				low++;
			}
			while (low < high && pivot.compareTo(Arr[low]) > 0) {
				low++;
			}
			if (low < high) {
				Arr[high] = Arr[low];//左侧比base大的树保存到Arr[3]中，j--到的位置
				high--;
			}
		}
		Arr[low] = pivot;//base给左侧比他大的数
		return low;//返回左侧比base大的数的下标
	}
	// 5.快速排序递归算法,右找小，左找大
	public AnyType[] qSort(int low, int high,AnyType[]Arr) {
		if (low < high) {
			int pivotloc = partitionSort(low, high,Arr);
			qSort(low, pivotloc - 1,Arr);
			qSort(pivotloc + 1, high,Arr);
		}
		return Arr;
	}

	// 6.直接选择排序
	//n个记录中找出最小的记录与第一个记录交换，n-1，第二个，以此类推，比较简单
	public AnyType[] selectSort(AnyType[] Arr) {
		AnyType temp;
		for (int i = 0; i < Arr.length - 1; i++) {// n-1趟排序
			// 每趟从r[i]开始的子序列中寻找最小关键字值得记录
			int min = i;// 设第i条记录的关键字值最小
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

	// 7.筛选法调整堆排序算法
	// 将以low为根结点的子树调整成小顶堆，low、和high分别是序列的上界和下界
	public void sift(int low, int high,AnyType[]Arr) {
		int i = low;
		int j = 2 * i + 1;
		AnyType temp = Arr[i];
		while (j < high) {
			if (j < high - 1 && Arr[j].compareTo(Arr[j + 1]) > 0) {//选出最小的子树左右
				j++;
			}
			if (temp.compareTo(Arr[j]) > 0) {//左右子树比他小就换上去
				Arr[i] = Arr[j];
				i = j;//每一次j给i从j开始
				j = 2 * i + 1;
			} else {
				j = high + 1;
			}
		}
		Arr[i] = temp;
	}

	// 7.堆排序算法
	public AnyType[] heapSort(AnyType Arr[]) {
		int n = Arr.length;
		AnyType temp;
		for (int i = n / 2 - 1; i >= 0; i--) {//非叶子结点n/2-1开始调整的根结点，得到一个初始堆
			sift(i, n,Arr);
		}
		for (int i = n - 1; i > 0; i--) {
			temp = Arr[0];
			Arr[0] = Arr[i];//最后一个和第一个交换
			Arr[i] = temp;
			sift(0, i,Arr);
		}
		return Arr;
	}

	//两个相邻的有序序列的归并
	public void merge(AnyType[] r,AnyType[] order,int h,int m,int t){//h->m,m+1->t
		int i = h,j=m+1,k=h;
		while(i<=m&&j<=t){//两个相邻子序列归并到order中
			if(r[i].compareTo(r[j])<=0){//较小值复制到order中
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
	
	//一趟归并排序
	public void mergepass(AnyType [] r, AnyType [] order,int s , int n){//s,子序列的长度
		int p = 0;//p 为每一对待合并表的第一个元素的下标初值为0
		while(p+2*s-1<n-1){//两两归并长度均为s的有序表
			merge(r,order,p,p+s-1,p+2*s-1);
			p+=2*s;//向后移，子序列排序
		}
		if(p+s-1<n-1){
			merge(r,order,p,p+s-1,n-1);
		} else{
			for(int i = p;i <= n-1;i++){
				order[i] = r[i];
			}
		}
		
	}
	
	//二路归并排序算法
	public void mergeSort(AnyType [] Arr){
		int s =1;
		int n =Arr.length;
		AnyType [] temp = (AnyType[]) new Integer[n];
		while(s<n){
			mergepass(Arr, temp, s, n);//一趟归并排序，将r数组中各子序列归并到temp中
			s*=2;//子序列长度加倍
			mergepass(temp, Arr, s, n);
			s*=2;
		}
	}
	//链式基数排序
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
		System.out.println("共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		/*for(int i:Arr3)
			System.out.print(i+" ");*/
		/*begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.mergeSort(Arr);//6-27
		System.out.println("归并排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.shellSort(d, Arr);//1149=1443
		System.out.println("shell排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.InsertSort(Arr);//1558-2700
		System.out.println("插入排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.bubbleSort(Arr);//10318
		System.out.println("冒泡排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.selectSort(Arr);//1839-2305
		System.out.println("选择排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.qSort(0, 30000,Arr);//16-24
		System.out.println("快速排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");
		
		begin = (int) System.currentTimeMillis();
		System.out.println(begin);
		mySort.heapSort(Arr);//18-32
		System.out.println("堆排序共用时间"+(int) (System.currentTimeMillis()-begin)+"毫秒");*/
		
		
	}

}
