package ��ϰ����;

public class ʵ����Acount {
	String zhanghao;
	 String name;
	 double yuer;
	public ʵ����Acount() {
	}
	public ʵ����Acount(String zhanghao, String name, double yuer) {
		
		this.zhanghao = zhanghao;
		this.name = name;
		this.yuer = yuer;
	}
	
public ʵ����Acount(String name) {
		
		this.name = name;
	}
public double cunqian(double qian){
	this.yuer+=qian;
	System.out.println(this.name+"�������Ϊ"+this.yuer+" Ԫ");
	return this.yuer;
}
public double quqian(double qian){
if(this.yuer<qian){
	System.out.println(this.name+"�Ա����������㣬��ǰ���Ϊ"+this.yuer+"Ԫ");
	return this.yuer;
}
else{
	this.yuer-=qian;
	System.out.println(this.name+"����ǰ�����Ϊ"+this.yuer+"Ԫ");
	return this.yuer;
}
}
public void chaxun(){
	System.out.println(this.name+"����ǰ�����Ϊ"+this.yuer+"Ԫ");
	
}
public double zhuanzhang(ʵ����Acount other,double qian){
	if(qian>this.yuer){
		System.out.println(this.name+"��Ǹ���������㣬�޷�ת��");
	}
	else{
	other.yuer+=qian;
	this.yuer-=qian;
	System.out.println(other.name+" "+this.name+"����ת�˺󣬵�ǰ�����Ϊ"+other.yuer+"Ԫ");
	System.out.println(this.name+"����"+other.name+"ת�˺�,��ǰ�����Ϊ"+other.yuer+"Ԫ");
	
	
}
	return other.yuer;
}
public String getZhanghao() {
	return zhanghao;
}
public void setZhanghao(String zhanghao) {
	this.zhanghao = zhanghao;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getYuer() {
	return yuer;
}
public void setYuer(double yuer) {
	this.yuer = yuer;
}

}













