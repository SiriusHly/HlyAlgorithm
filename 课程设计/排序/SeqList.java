package ����;


/*
 * author��������
 * time:2016.12.6
 * �������˳�������������
 */
public class SeqList {

	public RecordNode[] r;// ˳����¼�������
	public int curlen;// ˳����ȣ�����¼����
	// ����һ���洢�ռ�Ϊsize��˳���

	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize];
		this.curlen = 0;
	}

	// �ڵ�ǰ˳���ĵ�i�����֮ǰ����һ��RecordNode���͵Ľ��
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length)
			throw new Exception("˳���λ������");
		if (curlen < 0 || curlen > r.length)
			throw new Exception("����λ�ò�����");
		for (int j = curlen; j > i; j--)
			r[j] = r[j - 1];
		r[i] = x;
		this.curlen++;
	}

	/*
	 * �������� ÿ�˽�һ��������ļ�¼������ؼ���ֵ�Ĵ�С���뵽ǰ���Ѿ��ź�����ʵ�λ��
	 * 
	 */
	// ���������ڵ�ֱ�Ӳ������򷽷�
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

	// �������ڵ�ֱ�Ӳ������򷽷�,n���洢��Ԫ��˳���ֻ�ܴ��n-1����¼
	public void insertSortWithGuard() {
		int i, j;
		for (i = 0; i < this.curlen; i++) {// n-1��ɨ��
			r[0] = r[i];// ��������ĵ�i����¼�ݴ����r[0]�У�r[0]Ϊ������
			for (j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--)
				r[j + 1] = r[j];
			r[j + 1] = r[0];// ѭ����j--���Դ�ʱj++

		}
	}

	// ϣ������
	public void shellSort(int[] d) {// dΪ����������
		RecordNode temp;
		int i, j;
		// �����������������룬������ɨ��
		for (int k = 0; k < d.length; k++) {
			// һ�������ɸ��ֱ�ÿ����¼���ֱ��ڽ���ֱ�Ӳ�������
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

	// ð�������㷨
	public void bubbleSort() {
		RecordNode temp;// �����ڵ�
		boolean flag = true;// �Ƿ񽻻��ı��
		for (int i = 1; i < this.curlen && flag; i++) {// �н���ʱ�ٽ�����һ�ˣ����n-1��
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
