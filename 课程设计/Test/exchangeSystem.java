package Test;


public class exchangeSystem {

	public exchangeSystem() {
	}

	public static void main(String[] args) {
		
		//十六转二进制
		System.out.println("十六转二进制"+Integer.toBinaryString(Integer.valueOf("05",16)));
		//十六夜转十进制
		System.out.println("十六夜转十进制"+Integer.valueOf("05",16).toString());
		//十六转八进制
		System.out.println("十六转八进制"+Integer.toOctalString(Integer.valueOf("5",16)));
		//十进制转成十六进制：
		//System.out.println(Integer.toHexString(n1));
		//十进制转成八进制
		//System.out.println(Integer.toOctalString(n1));
		//十进制转成二进制
		System.out.println("十进制转成二进制"+Integer.toBinaryString(231));
		//八进制转成十进制
		//System.out.println(Integer.valueOf("576",8).toString());
		//八进制转成二进制
		//System.out.println(Integer.toBinaryString(Integer.valueOf("23",8)));
		//八进制转成十六进制
		System.out.println("八进制转成十六进制"+Integer.toHexString(Integer.valueOf("101",8)));
		//二进制转十进制
		System.out.println("二进制转十进制"+Integer.valueOf("11100111",2).toString());
		//二进制转八进制
		//System.out.println(Integer.toOctalString(Integer.parseInt("0101", 2)));
		//二进制转十六进制
		//System.out.println(Integer.toHexString(Integer.parseInt("0101", 2)));
		
		
	}

}
