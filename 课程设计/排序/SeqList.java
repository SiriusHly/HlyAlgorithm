package 排序;


/*
 * author：黄良运
 * time:2016.12.6
 * 待排序的顺序表描述类如下
 */
public class SeqList {

	public RecordNode[] r;// 顺序表记录结点数组
	public int curlen;// 顺序表长度，及记录个数
	// 构造一个存储空间为size的顺序表

	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize];
		this.curlen = 0;
	}

	// 在当前顺序表的第i个结点之前插入一个RecordNode类型的结点
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length)
			throw new Exception("顺序标位置已满");
		if (curlen < 0 || curlen > r.length)
			throw new Exception("插入位置不合理");
		for (int j = curlen; j > i; j--)
			r[j] = r[j - 1];
		r[i] = x;
		this.curlen++;
	}

	/*
	 * 插入排序 每趟将一个待排序的记录，按其关键字值的大小插入到前面已经排好序的适当位置
	 * 
	 */
	// 不带监视哨的直接插入排序方法
	public void insertSort() {
		RecordNode temp;
		int i, j;
		for (i = 1; i < this.curlen; i++) {
			temp = r[i];
			for (j = i - 1; j >= 0 && temp.key.compareTo(r[j].key) < 0; j--)
				r[j + 1] = r[j];
			r[j + 1] = temp;
		}
	}

	// 带监视哨的直接插入排序方法,n个存储单元的顺序表只能存放n-1个记录
	public void insertSortWithGuard() {
		int i, j;
		for (i = 0; i < this.curlen; i++) {// n-1躺扫描
			r[0] = r[i];// 将待插入的第i条记录暂存放在r[0]中，r[0]为监视哨
			for (j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--)
				r[j + 1] = r[j];
			r[j + 1] = r[0];// 循环里j--所以此时j++

		}
	}

	// 希尔排序
	public void shellSort(int[] d) {// d为增量的数组
		RecordNode temp;
		int i, j;
		// 控制增量，增量减半，若干躺扫描
		for (int k = 0; k < d.length; k++) {
			// 一趟中若干个字表，每个记录在字表内进行直接插入排序
			int dk = d[k];
			for (i = dk; i < this.curlen; i++) {
				temp = r[i];
				for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk) {
					r[j + dk] = r[j];
				}
				r[j + dk] = temp;
			}
		}

	}

	// 冒泡排序算法
	public void bubbleSort() {
		RecordNode temp;// 辅助节点
		boolean flag = true;// 是否交换的标记
		for (int i = 1; i < this.curlen && flag; i++) {// 有交换时再进行下一趟，最多n-1躺
			flag = false;
			for (int j = 0; j < this.curlen - 1; j++) {
				if (r[j].key.compareTo(r[j + 1].key) > 0) {
					temp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = temp;
					flag = true;
					display();
				}
			}

		}
	}

	public void display() {
		for (int i = 0; i < r.length; i++)
			System.out.print(r[i].key + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		SeqList seqList = new SeqList(4);
		for (int i = 0; i < 4; i++) {
			//seqList.r[i].key = ;
			seqList.curlen++;
		}
		seqList.bubbleSort();
	}
}
