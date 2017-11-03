package File_Summary;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTest_hly {

	public FileTest_hly() {
	}

	public static void main(String[] args)throws IOException {
		//BufferedWriter s = new BufferedWriter("f:\\book\\hly5.txt");
		File fw = new File("f:\\book\\hly5.txt");
		//OutputStreamWriter g = new OutputStreamWriter("f:\\book\\hly6.txt");
		//FileWriter fd = new FileWriter("f:\\book\\hly5.txt");
	DataInputStream fp  = new DataInputStream(new FileInputStream("f:\\bppk\\hly4.txt"));
	InputStreamReader l = new InputStreamReader(fp);
	
		
		
		try {
			FileWriter f = new FileWriter("f:\\book\\hly5.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
