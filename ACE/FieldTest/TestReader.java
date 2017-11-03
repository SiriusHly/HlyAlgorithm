package FieldTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestReader {

	public TestReader() {
	}
	public static void main(String []args){
		int Num;
		String name[],classes[];
		InputStreamReader studio = new InputStreamReader(System.in);
		BufferedReader  bufIn= new BufferedReader (studio);
		try{
			System.out.println("star read student message");
System.out.println("please input student count");
Num = Integer.parseInt(bufIn.readLine());
   name = new String[Num];
   classes= new String[Num];
   for(int i=0;i<Num;i++){
	   System.out.println((i+1)+"hao");
	   System.out.print("name: ");
	   name[i]= bufIn.readLine();
	   System.out.print("classes:");
	   classes[i]=bufIn.readLine();
   }
   System.out.println("already complete student input");
   System.out.println("star studert apparence");
   for(int i= 0;i<Num;i++){
	   System.out.print((i+1)+"hao_");
	   System.out.print("name"+name[i]);
	   System.out.print("classes"+classes[i]);
   }
   studio.close();
   bufIn.close();
		}
		catch(IOException e){
			System.out.println("IOExceptiom");
		}
	}

}
