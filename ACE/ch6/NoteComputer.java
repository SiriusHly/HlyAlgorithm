package ch6;

public class NoteComputer extends Computer {
	static{
		System.out.println("NoteComputer��ľ�̬������������䣬���濪ʼ���徲̬��Ա����");
	}
	private static Displayer displayer=new Displayer();
	public NoteComputer() {
		System.out.println("����һ̨�ʼǱ����ԣ��Ҹձ����������죩����,�������޲����Ĺ��췽��������");
	}
	public NoteComputer(MainBoard mb,HardDisk hd,Cpu cpu,Displayer displayer) {
		super(mb,hd,cpu);
		this.displayer = displayer;
		System.out.println("����һ̨�ʼǱ����ԣ��Ҹձ����������죩����,�������в����Ĺ��췽��������");
	}

	public static void main(String[] args) {
		System.out.println("main���������濪ʼ���������죩��һ̨�ʼǱ�����,��ֻ��ҪCpu��Intel�ģ���Ĳ��ں�,���� Ҫ���޲����Ĺ��췽������");
		NoteComputer computer1=new NoteComputer();
		System.out.println("\n\nmain���������濪ʼ���������죩�ڶ�̨�ʼǱ�����,�Һܹ�ע���塢Ӳ�̡�Cpu����ʾ����Ʒ�ƣ�����Ҫ���в����Ĺ��췽������");
		System.out.println("main�������ȴ����ĸ���Ա����");
		MainBoard mb=new MainBoard("����");
		HardDisk hd=new HardDisk("����");
		Cpu cpu=new Cpu("Intel");
		Displayer displayer=new Displayer("IBM");
		System.out.println("main������Ȼ��Ҫ����NoteComputer���в������췽�������ʼǱ����Զ���");
		NoteComputer computer2=new NoteComputer(mb,hd,cpu,displayer);
	}
}
class Displayer{
	String type;
	public Displayer(){
		type="û��Ʒ��";
		System.out.println("����һ��ʼǱ�ר����ʾ�����Ҹձ����������죩����,�������޲����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
	public Displayer(String type){
		this.type=type;
		System.out.println("����һ��ʼǱ�ר����ʾ�����Ҹձ����������죩����,�������в����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
}
