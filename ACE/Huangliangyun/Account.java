package Huangliangyun;

public class Account{
	   String name;
	   double yuer;
	   public Account(String name){
	      this.yuer = 100;
	      this.name = name;
	   }
	   public Account(String name ,double newyuer){
	      this.yuer = newyuer;
	      this.name = name;
	   }
	   public  double cunqian(double qian){
	      this.yuer+=qian;
	      return this.yuer;
	   }
	   public double quqian(double qian){
	      if(qian>this.yuer){
	         System.out.println("��Ǹ����������");
	      }
	          else{
	            this.yuer-=qian;
	          }
	               return this.yuer;
	   }
	   public double zhuanzhang(Account otherAccount,double qian){
	      if(qian>this.yuer){
	         System.out.println("��Ǹ����������,�޷�ת��");
	      }
	         else{
	            this.yuer-=qian;
	               otherAccount.cunqian(qian);
	         }
	         return this.yuer;
	   }
	  
	}






















