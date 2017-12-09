package 排序;
/*
 * 2017.12.9
 * author 黄良运
 * 排序算法
 */
public class MySort<AnyType extends Comparable<? super AnyType>> {
	//直接插入排序
	public void InsertSort(AnyType [] Arr){
		int i ,j ;
		AnyType temp ;
		for( i = 0;i<Arr.length;i++){
			temp = Arr[i];
			for(j=i-1;j>=0&&temp.compareTo(Arr[j])<0;j--)
				Arr[j+1] = Arr[j];
			Arr[j+1] = temp;
		}
	}
	
	//直接插入排序带监视哨
	public void InsertSortWithGuard(AnyType [] Arr){
		int i ,j ;
		AnyType temp;
		for( i = 1;i<Arr.length;i++){
			Arr [0] = Arr[i];
			for(j =i-1;Arr[0].compareTo(Arr[j])<0;j--)
				Arr[j+1] = Arr[j];
			Arr[j+1] = Arr[0];
				
		}
	}
	
	

}
