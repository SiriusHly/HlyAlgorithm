package MyList;

public class SqList implements Ilist {
	private Object[] listElem;
	private int curLen;

	public SqList(int maxSize) {
		curLen = 0;
		listElem = new Object[maxSize];
	}

	@Override
	public void clear() {
		curLen = 0;
	}

	@Override
	public boolean isEmpty() {

		return curLen == 0;
	}

	@Override
	public int length() {

		return curLen;
	}

	@Override
	public Object get(int i) {
		if (i < 0 || i > curLen - 1)
			try {
				throw new Exception("��" + i + "��Ԫ�ز�����");
			} catch (Exception e) {

				e.printStackTrace();
			}
		return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length)// �ж�˳����Ƿ�����
			throw new Exception("˳�������");
		if (i < 0 || i > curLen)
			throw new Exception("����˳�򲻺Ϸ�");
		for (int j = curLen; j > i; j--)//��ʱcurLen���±�,���һ��j==i+1��i+1=i��ֻ�ܵ��ţ���Ȼ�ᱻ����
			listElem[j] = listElem[j - 1];//j-1��ֵ��j�ڲ��븲��
		listElem[i] = x;
		curLen++;
	}

	@Override
	public void remove(int i) throws Exception {
		if(i<0||i>curLen-1)//�����Ǽ�һ
			throw new Exception("ɾ��λ�ò��Ϸ�");
		for(int j=i;j<curLen-1;j++)//������С�ڼ�һ
			listElem[j]=listElem[j+1];//j+1��ֵ��j,���渲�Ǹ�ǰ�棬j=(j-2)+1
		curLen--;//��©����һ
	}

	@Override
	public int indexOf(Object x) {
		int j=0;//���ݱ��д��Ƚϵ�����Ԫ�أ�0��ʾ��0������Ԫ��
		while(j<curLen||!listElem[j].equals(x))
			j++;
		if(j<curLen)
			return j;
		else
			return -1;
	}

	@Override
	public void display() {
		for (int j = 0; j < curLen; j++) {
			System.out.println(listElem[j] + " ");
		}
	}

}
