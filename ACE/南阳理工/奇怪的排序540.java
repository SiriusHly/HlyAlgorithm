package 南阳理工;
import java.io.BufferedInputStream;
import java.util.Scanner;
public class 奇怪的排序540 {

	
		public static void main(String[] args){
			//Scanner in = new Scanner(System.in);
			Scanner in = new Scanner(new BufferedInputStream(System.in));
			while(in.hasNext()){
				String str = in.nextLine();
				int s = 0;
				for(int j=0;j<str.length();j++){
					if(str.charAt(j)=='a')
						s++;								
				}
				System.out.println(s);
			}
		}
		}

