package 练习测试;

public class 实验三Acount {
	String zhanghao;
	 String name;
	 double yuer;
	public 实验三Acount() {
	}
	public 实验三Acount(String zhanghao, String name, double yuer) {
		
		this.zhanghao = zhanghao;
		this.name = name;
		this.yuer = yuer;
	}
	
public 实验三Acount(String name) {
		
		this.name = name;
	}
public double cunqian(double qian){
	this.yuer+=qian;
	System.out.println(this.name+"您的余额为"+this.yuer+" 元");
	return this.yuer;
}
public double quqian(double qian){
if(this.yuer<qian){
	System.out.println(this.name+"对比起，您的余额不足，当前余额为"+this.yuer+"元");
	return this.yuer;
}
else{
	this.yuer-=qian;
	System.out.println(this.name+"您当前的余额为"+this.yuer+"元");
	return this.yuer;
}
}
public void chaxun(){
	System.out.println(this.name+"您当前的余额为"+this.yuer+"元");
	
}
public double zhuanzhang(实验三Acount other,double qian){
	if(qian>this.yuer){
		System.out.println(this.name+"抱歉，您的余额不足，无法转账");
	}
	else{
	other.yuer+=qian;
	this.yuer-=qian;
	System.out.println(other.name+" "+this.name+"给你转账后，当前的余额为"+other.yuer+"元");
	System.out.println(this.name+"您给"+other.name+"转账后,当前的余额为"+other.yuer+"元");
	
	
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













