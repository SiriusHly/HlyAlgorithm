package FieldTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TextFileDemo {

	public TextFileDemo() {
	}
public static void main(String[]args){
	Writer writer =null;
	try{
		writer = new FileWriter("f:\\book\\hly9.txt");
		writer.write("line 1\n");
		writer.write("line 2\n");
		writer.write("true\n");		
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
	}
		Reader reader =null;
		try{
			reader = new FileReader("f:\\book\\hly9.txt");
			char [] buffer = new char [1024];
			int offset;
			/*while ((offset=reader.read(buffer))!=-1){
				System.out.print(new String(buffer ,0,offset));
				System.out.println(offset);
			}*/
			    /*offset=reader.read(buffer);
				System.out.print(new String(buffer ,0,offset));
				System.out.println(offset);*/
			
			/*while((offset=reader.read())!=-1){
				System.out.print((char)offset);
			}*/
			reader.read(buffer);
			for(int i=0;i<buffer.length;i++){
				System.out.print((char)buffer[i]);
			}
		
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(reader!=null){
				try{
					reader.close();
				}
				catch(IOException e){				
				}
			}
	}
}
}