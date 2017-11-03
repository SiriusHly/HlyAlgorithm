package ch6;

public class NoteComputer extends Computer {
	static{
		System.out.println("NoteComputer类的静态代码块输出的语句，下面开始定义静态成员变量");
	}
	private static Displayer displayer=new Displayer();
	public NoteComputer() {
		System.out.println("我是一台笔记本电脑，我刚被创建（制造）出来,我是用无参数的构造方法创建的");
	}
	public NoteComputer(MainBoard mb,HardDisk hd,Cpu cpu,Displayer displayer) {
		super(mb,hd,cpu);
		this.displayer = displayer;
		System.out.println("我是一台笔记本电脑，我刚被创建（制造）出来,我是用有参数的构造方法创建的");
	}

	public static void main(String[] args) {
		System.out.println("main方法：下面开始创建（制造）第一台笔记本电脑,我只需要Cpu是Intel的，别的不在乎,所以 要用无参数的构造方法创建");
		NoteComputer computer1=new NoteComputer();
		System.out.println("\n\nmain方法：下面开始创建（制造）第二台笔记本电脑,我很关注主板、硬盘、Cpu、显示器的品牌，所以要用有参数的构造方法创建");
		System.out.println("main方法：先创建四个成员对象");
		MainBoard mb=new MainBoard("联想");
		HardDisk hd=new HardDisk("西数");
		Cpu cpu=new Cpu("Intel");
		Displayer displayer=new Displayer("IBM");
		System.out.println("main方法：然后要调用NoteComputer的有参数构造方法创建笔记本电脑对象");
		NoteComputer computer2=new NoteComputer(mb,hd,cpu,displayer);
	}
}
class Displayer{
	String type;
	public Displayer(){
		type="没有品牌";
		System.out.println("我是一块笔记本专用显示器，我刚被创建（制造）出来,我是用无参数的构造方法创建的,我的型号是"+type);
	}
	public Displayer(String type){
		this.type=type;
		System.out.println("我是一块笔记本专用显示器，我刚被创建（制造）出来,我是用有参数的构造方法创建的,我的型号是"+type);
	}
}
