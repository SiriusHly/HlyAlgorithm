package FieldTest;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamDemo {

	public DataInputStreamDemo() {
	}
public static void main(String []args){
	DataInputStream  dataInput= null;
	try {
		dataInput = new DataInputStream(new FileInputStream("f:\\book\\hly2.txt"));
		int intData = dataInput.readInt();
		boolean booleanData = dataInput.readBoolean();
		System.out.println("intData="+intData);
		System.out.println("boleanData="+booleanData);
		
	}
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally{
		if(dataInput!=null){
			try{
				dataInput.close();
			}
			catch(IOException e){
				
			}
		}
	}
}
}
