package File_Summary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileWriterOrReader {

	public FileWriterOrReader() {
	}

	public static void main(String[] args) {
FileWriter fw = null;
BufferedWriter bw = null;
OutputStreamWriter osw = null;
FileReader fr = null;
BufferedReader br = null;
InputStreamReader isr = null;
char []bb = new char[1024];
try {
	fw = new FileWriter("f:\\book\\out2.txt");
	bw = new BufferedWriter(fw);
	for(int i=1;i<=100;i++){
		//bb[i-1]=(char)i;
		bw.write(String.valueOf(i));//一次读一个字符；
	}
	//bw.write(bb,0, 100);//一次读多个字符，放到字符数组中
	bw.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
	fr = new FileReader("f:\\book\\out2.txt");
	br = new BufferedReader(fr);
	String buf;
	
	while((buf=br.readLine())!=null){
		System.out.println(String.valueOf(buf));	
	}
	//br.read(bb,0, 100);
	br.close();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	}

}
