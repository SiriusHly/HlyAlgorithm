package ace;
import java.util.*;
import java.util.Scanner;
public class ×Ö·û´®´óÐ¡ {

	 public static void main(String[] args){
	 Scanner sc=new Scanner(System.in);
	 int T=sc.nextInt();
	 while(T-->0){
	 int n=sc.nextInt();
	 String[] strArray=new String[n];
	 for(int i=0;i<n;i++)
	 strArray[i]=sc.next();
	 strArray=StringSort(strArray);
	 System.out.println(strArray[0]);
	 }
	 }

	 public static String[] StringSort(String[] s){
	 List<String> list=new ArrayList<String>(s.length);
	 for(int i=0;i<s.length;i++)
	 list.add(s[i]);
	 Collections.sort(list);
	 return list.toArray(s);
	 }
	 }