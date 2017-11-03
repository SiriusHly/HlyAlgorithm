package FieldTest;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.InputStreamReader;

	public class Number2 {

	
	public static void main(String[]h) throws Exception{
		File file = new File("f:\\book\\hly4.txt");
		FileWriter fw = new FileWriter(file);
		FileReader fr = new FileReader(file);
	   
	    
		for(int i=0;i<100;i++){
			fw.write(Integer.toString(i)+" ");
		}
		fw.write(Integer.toString(99));
		fw.close();
		
		}
		
		
	}
	



