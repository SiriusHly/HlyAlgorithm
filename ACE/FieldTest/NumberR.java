package FieldTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class NumberR {

	public NumberR() {
	}
public static void main(String[]h) throws Exception{
	File file = new File("f:\\book\\hly4.txt");
	FileWriter fw = new FileWriter(file);
	FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	for(int i=0;i<5;i++){
		fw.write(br.readLine()+" ");
	}
	fw.close();
	String s[] = br.readLine().trim().split(" ");
	for(int i=0;i<5;i++){
		System.out.print(s[i]+"");
	}
}
}
