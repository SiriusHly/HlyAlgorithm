package ����;
/*
 * 2017.12.9
 * author ������
 * �����㷨
 */
public class MySort<AnyType extends Comparable<? super AnyType>> {
	//ֱ�Ӳ�������
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
	
	//ֱ�Ӳ��������������
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
