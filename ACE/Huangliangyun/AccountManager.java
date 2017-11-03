package Huangliangyun;

class AccountManager {
	public static void main(String args[]){
	      Account zhangsan = new Account("zhangsan",1000);
	      Account lisi = new Account("lisi",300);
	            zhangsan.cunqian(500);
	               zhangsan.quqian(200);
	               System.out.println("你的余额是"+zhangsan.zhuanzhang(lisi,300));
	               System.out.println("您的余额是"+lisi.cunqian(500));
	      
	            
	
	}
}
