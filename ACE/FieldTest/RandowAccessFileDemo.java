package FieldTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandowAccessFileDemo {

	public RandowAccessFileDemo() {
	}
	public static void main(String []args){
		RandomAccessFile  randomAccessFile= null;
		try {
			randomAccessFile = new RandomAccessFile("f:\\book\\hly9.txt","rw");
			randomAccessFile.writeInt(99);
			randomAccessFile.writeByte('a');
			
			randomAccessFile.seek(4);
			char charData= randomAccessFile.readChar();
			System.out.println("charData="+charData);
			randomAccessFile.writeInt(5678);
			long p1 = randomAccessFile.getFilePointer();
			System.out.println("pointer="+p1);
			randomAccessFile.seek(0);
			int a1 = randomAccessFile.readInt();
			System.out.println("a1="+a1);
			randomAccessFile.seek(0);
			randomAccessFile.writeInt(200);
			randomAccessFile.seek(0);
			int a2 = randomAccessFile.readInt();
			System.out.println("a2="+a2);
			randomAccessFile.seek(6);
			int a3 = randomAccessFile.readInt();
			System.out.println("a3="+a3);
			long p2 = randomAccessFile.getFilePointer();
			System.out.println("pointer="+p2);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(randomAccessFile!=null){
				try{
					randomAccessFile.close();
				}
				catch(IOException e){
			}
		}
				
	}

}
}