package ��ϰ����;

public class ʵ����AccountManager {

	public ʵ����AccountManager() {
	}
public static void main(String []args){
	ʵ����Acount zhangsan = new ʵ����Acount("001","����",1000);
	ʵ����Acount lisi = new ʵ����Acount("002","����",300);
	zhangsan.cunqian(500);
	lisi.cunqian(500);
	zhangsan.quqian(200);
	zhangsan.zhuanzhang(lisi, 300);
	zhangsan.chaxun();lisi.chaxun();
	
}
}
