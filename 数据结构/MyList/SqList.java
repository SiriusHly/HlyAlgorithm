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
				throw new Exception("第" + i + "个元素不存在");
			} catch (Exception e) {

				e.printStackTrace();
			}
		return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length)// 判断顺序表是否已满
			throw new Exception("顺序表已满");
		if (i < 0 || i > curLen)
			throw new Exception("插入顺序不合法");
		for (int j = curLen; j > i; j--)//此时curLen是下标,最后一步j==i+1，i+1=i；只能倒着，不然会被覆盖
			listElem[j] = listElem[j - 1];//j-1赋值给j在插入覆盖
		listElem[i] = x;
		curLen++;
	}

	@Override
	public void remove(int i) throws Exception {
		if(i<0||i>curLen-1)//这里是减一
			throw new Exception("删除位置不合法");
		for(int j=i;j<curLen-1;j++)//这里是小于减一
			listElem[j]=listElem[j+1];//j+1赋值给j,后面覆盖给前面，j=(j-2)+1
		curLen--;//别漏掉减一
	}

	@Override
	public int indexOf(Object x) {
		int j=0;//数据表中待比较的数据元素，0表示第0个数据元素
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
