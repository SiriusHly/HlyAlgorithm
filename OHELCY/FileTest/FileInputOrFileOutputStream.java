package FileTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOrFileOutputStream {

	public FileInputOrFileOutputStream() {
	}

	public static void main(String[] args) {
InputStream input = null;
OutputStream output =null;
try {
	output = new FileOutputStream("f:\\book\\hly3.txt");
	
byte db [] = new byte[1024]; 
db ="hello word".getBytes();
output.write(db);
byte c;
for(int i=0;i<100;i++){
output.write(i);
}
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {//±ØÐë¼ÓÉÏ
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
}
try {
	input = new FileInputStream("f:\\book\\hly3.txt");
	byte []cc = new byte[1024];
	int tt;
	int ss = input.available();
	input.read(cc);
	for(int i=0;i<cc.length;i++){
		System.out.print(((char)cc[i]));
	}
	/*for(int i=0;i<ss;i++){
		tt=input.read();
		System.out.print((char)tt+ " ");
	}*/
	/*for(int i=0;i<ss;i++){
		char temp = (char)input.read();
		System.out.print(temp);
	}*/
	while((tt=input.read())!=-1){
		System.out.print((char)tt);
	}
	
	
}catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}catch(IOException e){
	
}
finally{
	if(input!=null){
		try{
			input.close();
		}
		catch(IOException e){
			
		}
	}
}

	}

}
