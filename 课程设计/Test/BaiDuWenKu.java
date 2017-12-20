package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BaiDuWenKu {
	public static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// ¸ù¾Ý×Ö½ÚÂëÅÐ¶Ï
	}

	public static void main(String[] args) {

		BaiDuWenKu baiDuWenKu = new BaiDuWenKu();
		Scanner in = new Scanner(System.in);
		FileWriter fw = null;
		BufferedWriter bw = null;
		OutputStreamWriter osw = null;
		FileReader fr = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		char[] bb = new char[1024];
		int flag = 1;
		try {
			fw = new FileWriter("C:/Users/hly/Desktop/tralate.txt");
			bw = new BufferedWriter(fw);
			// String str = in.nextLine();
			bw.write("  ");
			while (flag == 1) {
				String str = in.nextLine();
				for (int i = 0; i < str.length(); i++) {
					if (isChinese(str.charAt(i))) {
						bw.write(String.valueOf(str.charAt(i)));
					}

					else if (str.charAt(i) == '£¬' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')
							|| str.charAt(i) == '~' || str.charAt(i) == '¡¢'|| str.charAt(i) == '£­' || str.charAt(i) == '£º' ) {
						bw.write(String.valueOf(str.charAt(i)));
					} else if (str.charAt(i) == '¡£' || str.charAt(i) == '£»' || str.charAt(i) == '£¡') {
						bw.write(String.valueOf(str.charAt(i) + "\n"));
					}

					else if (str.equals("$"))
						flag = 0;
				}
			}

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fr = new FileReader("C:/Users/hly/Desktop/tralate.txt");
			br = new BufferedReader(fr);
			String buf;

			while ((buf = br.readLine()) != null) {
				System.out.println(String.valueOf(buf));
			}
			// br.read(bb,0, 100);
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
