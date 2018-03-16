package 实验四;
/*
 * author:黄良运
 * time：2017.12.6
 * 折半查找
 */
public class Find<AnyType extends Comparable<? super AnyType>> {

	public int search(AnyType Arr[], AnyType x) {
		int mid, low, high;
		low = 0;
		high = Arr.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			//System.out.println("mid: "+mid+"Arr[mid]: "+Arr[mid]+" low: "+low+" high: "+high);
			if (Arr[mid].compareTo(x) == 0)
				return mid;
			else if (Arr[mid].compareTo(x) > 0)//x比较小的话，就缩小，height缩小，所以为mid-1
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	public static void main(String []y){
		//Scanner in  = new Scanner(System.in);
		Integer Arr[] = {5,14,18,21,23,29,31,35};
		Find<Integer> find = new Find<Integer>();
		System.out.println(find.search(Arr, 23)+": "+Arr[find.search(Arr, 23)]);		
	}

}
