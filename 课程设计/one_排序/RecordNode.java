package one_排序;



/*
 * author:黄良运
 * time ：2017.12.7
 * 排序的顺序表记录类
 */
//记录结点类
public class RecordNode {
	public Comparable key;//可以被赋值给任何实现Comparable接口的对象
	public Object element;//保存结点
	public RecordNode(Comparable key, Object element) {
		this.key = key;
		this.element = element;
	}
	public RecordNode(Comparable key) {
		this.key = key;
	}
	
	

}
