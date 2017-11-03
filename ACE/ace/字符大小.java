package ace;
import java.io.*;
import java.util.*;
public class ×Ö·û´óÐ¡ {
public static void main(String[] args) throws Exception{
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
int time1 = Integer.parseInt(in.readLine());
for (int i = 0; i < time1; i++) {
int time2 = Integer.parseInt(in.readLine());
TreeSet<String> set = new TreeSet<String>();
for(int j = 0; j < time2; j++) {
set.add(in.readLine());
}
System.out.println(set.first());
}
in.close();
}
}