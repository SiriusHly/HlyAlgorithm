package ����;

import java.util.ArrayList;
import java.util.List;

/*
 * author :������
 * time��2017.12.7
 * ˳����¼�ؼ�����
 */
public class KeyType implements Comparable<KeyType>{
	
	public int key;
	
	public KeyType() {
	}
	
	public KeyType(int key) {
		this.key = key;
	}
	
	public String toStrng(){
		return key + " ";
	}

	@Override
	public int compareTo(KeyType another) {//���ǱȽϹؼ��ִ�С�ķ���
		int thisVal = this.key;
		int anotherVal = another.key;
		return (thisVal<anotherVal?-1:(thisVal==anotherVal?0:1));
	}

}
