package 排序;

import java.util.ArrayList;
import java.util.List;

/*
 * author :黄良运
 * time：2017.12.7
 * 顺序表记录关键字类
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
	public int compareTo(KeyType another) {//覆盖比较关键字大小的方法
		int thisVal = this.key;
		int anotherVal = another.key;
		return (thisVal<anotherVal?-1:(thisVal==anotherVal?0:1));
	}

}
