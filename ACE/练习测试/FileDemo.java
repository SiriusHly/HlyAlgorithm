package ¡∑œ∞≤‚ ‘;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileDemo {
	public FileDemo() {
	}

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		FileWriter fw = null;
		FileReader fr = null;
BufferedWriter bw = null;
BufferedReader br = null;


		/*try {
			fos = new FileOutputStream("f:\\book\\my.txt");
			bos = new BufferedOutputStream(new DataOutputStream(fos));
			for (int i = 1; i <= 100; i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {

					bos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			fis = new FileInputStream("f:\\book\\my.txt");
			bis = new BufferedInputStream(new DataInputStream(fis));
			String buf;
			for (int i = 0; i < 100; i++) {
				int s = bis.read();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
			try {
				fw = new FileWriter("f:\\book\\my2.txt");
				bw = new BufferedWriter(fw);
				for(int i=1;i<=100;i++){
					fw.write(Integer.toString(i));
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					if(fw!=null){
					bw.close();
					fw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		try {
			fr = new FileReader("f:\\book\\my2.txt");
			br = new BufferedReader(fr);
			int s;
			/*for(int i=0;i<100;i++){
				s=fr.read();
				System.out.println(Integer.toString(s));
				
			}*/
			int buf;
			
			while((buf=br.read())!=-1){
				System.out.print((char)buf);	
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(fr!=null){
				fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}