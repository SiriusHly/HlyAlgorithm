package 南阳理工;
import java.util.Scanner;
public class 无地之主845 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int[] a = new int[100];
int[] b = new int[100];
int n = 1;
int m = 1;
int i = 0;
int j = 0;
while ((m = scanner.nextInt()) != 0 && (n = scanner.nextInt()) != 0) {
a[m] = a[m] + n;

b[j] = m;
j = j + 1;

}
for (int i1 = 0; i1 < a.length; i1++) {
if (b[i1] > 0&&a[b[i1]]>0) {
System.out.println(b[i1] + " " + a[b[i1]]);
a[b[i1]]=0;
}
}

}
}