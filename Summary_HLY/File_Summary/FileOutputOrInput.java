package File_Summary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputOrInput {

	


	public static void main(String[] args) {
FileOutputStream fos = null;
BufferedOutputStream  bos= null;
DataOutputStream dos = null;
FileInputStream fis = null;
BufferedInputStream bis = null;
DataInputStream dis = null;
byte []bb = new byte[1024];
 try {
	fos = new FileOutputStream("f:\\out\\out1.txt");
	 dos = new DataOutputStream(new BufferedOutputStream(fos));
	 for(int i=1;i<=100;i++){	 
			dos.write(i);//一次读入一个字节
			bb[i-1]=(byte)i;
	 }
	  dos.write(bb);//一次读多个字符，放到字符数组中
		dos.close();
 }
 catch(IOException e){
	 e.printStackTrace();
 }
 finally{
	 try{
	 if(dos!=null){
		 dos.close();
	 }
	 }
	 catch(IOException e){
		 
	 }
 }
 
 try {
	fis = new FileInputStream("f:\\out\\out1.txt");
	dis = new DataInputStream(new BufferedInputStream(fis));
	int t;
	while((t=dis.read())!=-1){
		if(t%10==0){
			System.out.println();
		}
		System.out.print(t+" ");
	}
	/*String buf;
	while((buf=dis.readLine())!=null){
		System.out.println(buf);
		
	}*/
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 finally{
	 try{
		 if(dis!=null){
			 dis.close();
		 }
	 }
	 catch(IOException e){
		 
	 }
 }
 
	}
}
		

