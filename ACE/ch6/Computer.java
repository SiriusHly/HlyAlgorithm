package ch6;

public class Computer {                        //����
	private MainBoard mb=new MainBoard();      //���壬���Ա����
	private HardDisk hd=new HardDisk("");       //Ӳ�̣����Ա����
	static{
		System.out.println("Computer��ľ�̬������������䣬���濪ʼ���徲̬��Ա����");                              //��̬�����
	}
	private static Cpu cpu=new Cpu("Intel");          //CPU����̬��Ա����
	public Computer(){                           //Ĭ�ϣ��޲Σ����췽��      
		System.out.println("����һ̨���ԣ��Ҹձ����������죩����,�������޲����Ĺ��췽��������");
	}
	public Computer(MainBoard mb,HardDisk hd,Cpu cpu) {    //���ι��췽��
		this.hd = hd;this.mb = mb;this.cpu = cpu;
		System.out.println("����һ̨���ԣ��Ҹձ����������죩����,�������в����Ĺ��췽��������");
	}
	public static void main(String args[]){
		System.out.println("main���������濪ʼ���������죩��һ̨����,��ֻ��ҪCpu��Intel�ģ���Ĳ��ں�,�������޲����Ĺ��췽������");
		Computer computer1=new Computer();

		System.out.println("\n\nmain���������濪ʼ���������죩�ڶ�̨����,�Һܹ�ע���塢Ӳ�̡�Cpu��Ʒ�ƣ��������в����Ĺ��췽������");
		System.out.println("main�������ȴ���������Ա����");
		MainBoard mb=new MainBoard("����");
		HardDisk hd=new HardDisk("����");
		Cpu cpu=new Cpu("Intel");

		System.out.println("main������Ȼ�����Computer���в������췽���������Զ���");
		Computer computer2=new Computer(mb,hd,cpu);
	}
}

class HardDisk{
	String type;
	public HardDisk(){                         //�޲ι��췽��
		type="û��Ʒ��";
		System.out.println("����һ��Ӳ�̣��Ҹձ����������죩����,�������޲����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
	public HardDisk(String type){                //�вι��췽��
		this.type=type;
		System.out.println("����һ��Ӳ�̣��Ҹձ����������죩����,�������в����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
}
class MainBoard{
	String type;
	public MainBoard(){
		type="û��Ʒ��";
		System.out.println("����һ�����壬�Ҹձ����������죩����,�������޲����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
	public MainBoard(String type){
		this.type=type;
		System.out.println("����һ�����壬�Ҹձ����������죩����,�������в����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
}
class Cpu{
	String type;
	public Cpu(){
		type="û��Ʒ��";
		System.out.println("����һ��CPU���Ҹձ����������죩����,�������޲����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
	public Cpu(String type){
		this.type=type;
		System.out.println("����һ��CPU���Ҹձ����������죩����,�������в����Ĺ��췽��������,�ҵ��ͺ���"+type);
	}
}
