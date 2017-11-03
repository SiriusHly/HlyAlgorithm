package MyPractiseList;

public interface Ilist {
	public void clear();
	public boolean isEmpty();
	public void remove(int i) throws Exception;
	public void insert (int i,Object x) throws Exception;
	public int length();
	public void display();
	public Object get(int i) throws Exception;
	public int indexOf(Object x);

}
