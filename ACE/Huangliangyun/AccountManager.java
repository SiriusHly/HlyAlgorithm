package Huangliangyun;

class AccountManager {
	public static void main(String args[]){
	      Account zhangsan = new Account("zhangsan",1000);
	      Account lisi = new Account("lisi",300);
	            zhangsan.cunqian(500);
	               zhangsan.quqian(200);
	               System.out.println("��������"+zhangsan.zhuanzhang(lisi,300));
	               System.out.println("���������"+lisi.cunqian(500));
	      
	            
	
	}
}
