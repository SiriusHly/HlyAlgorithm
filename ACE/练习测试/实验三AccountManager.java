package 练习测试;

public class 实验三AccountManager {

	public 实验三AccountManager() {
	}
public static void main(String []args){
	实验三Acount zhangsan = new 实验三Acount("001","张三",1000);
	实验三Acount lisi = new 实验三Acount("002","李四",300);
	zhangsan.cunqian(500);
	lisi.cunqian(500);
	zhangsan.quqian(200);
	zhangsan.zhuanzhang(lisi, 300);
	zhangsan.chaxun();lisi.chaxun();
	
}
}
