package MyList;

public class Example2_1 {

	public Example2_1() {
	}

	public static void main(String[] args) throws Exception {
		SqList L = new SqList(10);
		L.insert(0, 'a');
		L.insert(1, 'b');
		L.insert(2, 'c');
		L.insert(3, 'd');
		L.insert(4, 'z');
		int order = L.indexOf('z');
		if(order!=-1)
			System.out.println(order);
		else
			System.out.println("不包含该元素");
	}
}
