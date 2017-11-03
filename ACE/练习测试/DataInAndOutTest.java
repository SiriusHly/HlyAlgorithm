package ¡∑œ∞≤‚ ‘;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInAndOutTest {

	public DataInAndOutTest() {
	}

	public static void main(String[] args) {
		// File f = new File("f:\\book\\test.dat");
		String p = "f:\\book\\test.dat";
		FileOutputStream fos = null;
		FileInputStream fis = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			fos = new FileOutputStream(p);
			dos = new DataOutputStream(fos);
			dos.writeInt(100);
			dos.writeChar('x');
			dos.writeDouble(65.5);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(dos!=null){
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			fis = new FileInputStream(p);
			dis = new DataInputStream(fis);
			int a = dis.readInt();
			char c = dis.readChar();
			double s=dis.readDouble();
			System.out.println(a+" "+c+" "+s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(dis!=null){
				dis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
