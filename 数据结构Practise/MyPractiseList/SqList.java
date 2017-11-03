package MyPractiseList;

import java.util.Scanner;

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
	public void remove(int i) throws Exception {
		if (i < 0 || i > curLen-1)
			throw new Exception("����ɾ����λ�ò�����");
		else {
			for (int j = i; j < curLen-1; j++) {
				listElem[j] = listElem[j + 1];
			}
			curLen--;
		}
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length)
			throw new Exception("˳�������");
		if (i < 0 || i > curLen)
			throw new Exception("���������λ�ò��Ϸ�");
		else {
			for (int j = curLen; j > i; j--) {
				listElem[j] = listElem[j - 1];
			}
			listElem[i] = x;
			curLen++;
		}
	}

	@Override
	public int length() {

		return curLen;
	}

	@Override
	public void display() {
		for (int i = 0; i < curLen; i++) {
			System.out.print(listElem[i] + " ");
		}
	}

	@Override
	public Object get(int i) throws Exception {

		if (i < 0 || i > curLen - 1)
			throw new Exception("��Ԫ�ز�����");
		return listElem[i];
	}

	@Override
	public int indexOf(Object x) {

		for (int i = 0; i < curLen; i++) {
			if (listElem[i].equals(x))
				return i;
			break;
		}
		return -1;
		/*
		 * int j=0;//���ݱ��д��Ƚϵ�����Ԫ�أ�0��ʾ��0������Ԫ��
		 * while(j<curLen||!listElem[j].equals(x)) j++; if(j<curLen) return j;
		 * else return -1;
		 */

	}

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		SqList sq = new SqList(1024);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int j = in.nextInt();
			sq.insert(j, j);
		}
		int i = in.nextInt();
		sq.remove(i);
		sq.display();

	}

}
