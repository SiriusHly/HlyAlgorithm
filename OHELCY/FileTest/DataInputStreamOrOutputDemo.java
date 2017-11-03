package FileTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamOrOutputDemo {

	public DataInputStreamOrOutputDemo() {
	}
	public static void main(String []hly){
	DataInputStream intput = null;
	DataOutputStream output = null;
    try {
		output = new DataOutputStream(new FileOutputStream("f:\\book\\hly3.txt"));
		output.writeBoolean(true);
		for(int i=0;i<100;i++){
			output.writeInt(i);
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally{
    	if(output!=null){
    		try{
    			output.close();
    		}
    		catch(IOException e){
    	}
    }
   try {
	intput = new DataInputStream( new FileInputStream("f:\\book\\hly3.txt"));
    boolean da =intput.readBoolean();
    System.out.println(da);
    int data;
    for(int i=0;i<100;i++){
    data=	intput.readInt();
    	System.out.print(data+" ");//需要输才可以显示
    }
   } catch (FileNotFoundException e) {//不加上这行会报错
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	if(intput!=null){
		try{
			intput.close();
		}
		catch(IOException e){
			
		}
	}
}
}
	}
	

}
