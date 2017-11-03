package FieldTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedIODemo {

	public BufferedIODemo() {
	}

	public static void main(String[] args) {
BufferedWriter writer = null;
try{
	writer = new BufferedWriter(new FileWriter("f:\\book\\hly1.txt"));
	writer.write("line 1\n");
	writer.newLine();
	writer.write("line 2\n");
	writer.newLine();
}
catch(IOException e){
	e.printStackTrace();
}
finally{
	if(writer!=null){
		try{
			writer.close();
			
		}
		catch(IOException e){			
		}
	}
	BufferedReader reader = null;
	try{
		reader = new BufferedReader(new FileReader("f:\\book\\hly1.txt"));
		String buf;
		while((buf = reader.readLine())!=null)
			System.out.println(buf);
	}
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	finally{
		if(reader!=null)
			try{
				reader.close();
			}
			
		 catch (IOException e) {

		}
	
}
	}

	}
}
