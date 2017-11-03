package ch6;

public class Computer {                        //电脑
	private MainBoard mb=new MainBoard();      //主板，域成员变量
	private HardDisk hd=new HardDisk("");       //硬盘，域成员变量
	static{
		System.out.println("Computer类的静态代码块输出的语句，下面开始定义静态成员变量");                              //静态代码段
	}
	private static Cpu cpu=new Cpu("Intel");          //CPU，静态成员变量
	public Computer(){                           //默认（无参）构造方法      
		System.out.println("我是一台电脑，我刚被创建（制造）出来,我是用无参数的构造方法创建的");
	}
	public Computer(MainBoard mb,HardDisk hd,Cpu cpu) {    //带参构造方法
		this.hd = hd;this.mb = mb;this.cpu = cpu;
		System.out.println("我是一台电脑，我刚被创建（制造）出来,我是用有参数的构造方法创建的");
	}
	public static void main(String args[]){
		System.out.println("main方法：下面开始创建（制造）第一台电脑,我只需要Cpu是Intel的，别的不在乎,所以用无参数的构造方法创建");
		Computer computer1=new Computer();

		System.out.println("\n\nmain方法：下面开始创建（制造）第二台电脑,我很关注主板、硬盘、Cpu的品牌，所以用有参数的构造方法创建");
		System.out.println("main方法：先创建三个成员对象");
		MainBoard mb=new MainBoard("联想");
		HardDisk hd=new HardDisk("西数");
		Cpu cpu=new Cpu("Intel");

		System.out.println("main方法：然后调用Computer的有参数构造方法创建电脑对象");
		Computer computer2=new Computer(mb,hd,cpu);
	}
}

class HardDisk{
	String type;
	public HardDisk(){                         //无参构造方法
		type="没有品牌";
		System.out.println("我是一个硬盘，我刚被创建（制造）出来,我是用无参数的构造方法创建的,我的型号是"+type);
	}
	public HardDisk(String type){                //有参构造方法
		this.type=type;
		System.out.println("我是一个硬盘，我刚被创建（制造）出来,我是用有参数的构造方法创建的,我的型号是"+type);
	}
}
class MainBoard{
	String type;
	public MainBoard(){
		type="没有品牌";
		System.out.println("我是一块主板，我刚被创建（制造）出来,我是用无参数的构造方法创建的,我的型号是"+type);
	}
	public MainBoard(String type){
		this.type=type;
		System.out.println("我是一块主板，我刚被创建（制造）出来,我是用有参数的构造方法创建的,我的型号是"+type);
	}
}
class Cpu{
	String type;
	public Cpu(){
		type="没有品牌";
		System.out.println("我是一个CPU，我刚被创建（制造）出来,我是用无参数的构造方法创建的,我的型号是"+type);
	}
	public Cpu(String type){
		this.type=type;
		System.out.println("我是一个CPU，我刚被创建（制造）出来,我是用有参数的构造方法创建的,我的型号是"+type);
	}
}
