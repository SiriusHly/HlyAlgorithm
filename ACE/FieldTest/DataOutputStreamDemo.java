package FieldTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	public DataOutputStreamDemo() {
	}
	public static void main(String []hly)throws Exception{
		
		DataOutputStream dataOutput = null;
		DataInputStream dataInput=null;
		try {
			dataOutput = new DataOutputStream(new FileOutputStream("f:\\book\\hly3.txt"));
			StringBuffer buffer = new StringBuffer();		
			dataOutput.write(99);		
			//dataOutput.writeBoolean(true);
			dataOutput.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			if(dataOutput!=null){
				try{
					dataOutput.close();
					
				}
				catch(IOException e){
					
				}
			}
		}
		dataInput = new DataInputStream(new FileInputStream("f:\\book\\hly3.txt"));
		dataInput.read();
		try {
			dataInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}