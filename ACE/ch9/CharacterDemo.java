//课件chap8 p23
package ch9;

public class CharacterDemo {
	public static void main(String[] args) {
		String str=new String("fzyFZY1 2");
		System.out.println(str);

		char[] charArray=str.toCharArray();                                 //字符串转换成字符数组
		for(int i=0;i<charArray.length;i++){
			if(Character.isDigit(charArray[i])){
				System.out.println(charArray[i]+"  is a digit");
				continue;
			}
			if(Character.isLetter(charArray[i])){
				if(Character.isUpperCase(charArray[i]))
					System.out.println(charArray[i]+"  is a upperCase letter");
				else
					System.out.println(charArray[i]+"  is a lowerCase letter");
				continue;
			}
			System.out.println(charArray[i]+"  is not a letter or a digit");
		}
	}

}





/*
continue;语句提高运行效率，满足此条件一定不满足下面的条件不必再判断了，直接进行下一次循环

结果：

fzyFZY1 2
f  is a lowerCase letter
z  is a lowerCase letter
y  is a lowerCase letter
F  is a upperCase letter
Z  is a upperCase letter
Y  is a upperCase letter
1  is a digit
   is not a letter or a digit
2  is a digit



*/
