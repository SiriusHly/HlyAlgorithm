package File_Summary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class File_Hly {
/*
 * 作者：黄良运；
 */
/*常用到的字节输入流:
 *             FileInputStream  (读取文件输入流,指定文件地址，可以这么用InputStream f = new FileInputStream(...))
 *InputStream                    DataInputStream    (可以读取基本类型的数据)
 *             FilterInputStream(建立可过滤输入流)
 *                               BufferedInputStream(提高读取速度)
 *                                           
 *  int read()                                          读取一个字节，如果读到末端返回-1；
 *  int read(byte b [] )                                将输入流读到字节数组中，返回读入的字节数；
 *  int read(byte b [],int off,int len)                 从输入流中读取len个字符到b中，读的第一个 字节放到off处；如果off+len>b。length，抛出IndexOutputBoundsException;                                                
 *  long skin(long n)                                   从输入流中跳过n个字节，返回跳过的字节数，接着用read方法，读取n+1个 字节；*                                                     
 *  abstract void close()                               关闭输入流
 *  public BufferedInputStream(intputStream in,int size)in为底层输入流； size为缓冲区大小；
 *                                                   
 *  File file = new File("...");
 *  FileInputStream fis = new FileInputStream(file);    通过打开一个实际File类的对象file来创建一个FileInputStream
 *  
 *  InputStream fis = new FileInputStream("fileInputStreamDemo.java");
 *                                                       通过路径名来创建一个FileInputStream的对象;
 *  DataInputStream类的所有方法都是以read开头；readByte(); readLong(); readUTF();               
 *-----------------------------------------------------------------------------------------
 *                
 *             
 *常用的字节输出流：将缓存在计算机内存中的数据输出到外部设备
 *              FileOutputStream(写入文件输出流)
 *OutputStream                     DataOutputStream    (写入任何符合Java数据类型的信息)
 *              FilterOutputStream
 *                                 BufferedOutputStream(为输出提供缓冲过滤流)
 * 
 *  void write(int b)                    将整数b的低八位写入输出流；
 *  void write(byte b[])                 将字节数组写入输出；
 *  void write(byte b[],int off,int size)从字节b的off处开始向输出流写入len个字节；
 *  abstract void flush()                强制将输出流保存在缓冲区的数据写入目标数据源；
 *  public BufferedOutputStream(OutputStream out,int size)...
 * 
 *  FileOutputStream(File file);
 *  FileOutput(String pathName,boolean append);
 *  DataOutputStream                     基本数据类型写入数据目的地；
 *  writeBoolean(boolean v)
 *  writeChar(int v)
 *  writeChars(String s)                 将字符串s中所有的字符按顺序写入输出流，每个字符两个字节；
 * ---------------------------------------------------------------------------------------
 * 
 * 
 * 
 *常用的字符输入流：
 *         BufferedReader   (包含readLine()方法的缓冲输入字符流)
 *Reader   
 *                                                 FileReader(从文件读入输入流，读取字符文件)
 *         InputStreamReader(将字节输入流转化为字符输入流，从字节流到字符流的桥梁，可以如下面这么用：)
 *         
 *         DataInputStream fp  = new DataInputStream(new FileInputStream("f:\\bppk\\hly4.txt"));
	       InputStreamReader l = new InputStreamReader(fp);
 *           
 *   abstract void close()                          关闭输入流；                           
 *   int read();                                    从输入流读取一个字符，如果到达文件结尾，返回-1；
 *   int read (char buf[])                          从输入流中将指定个数的字符读入到数组buf中，返回读取字符的数目，达到结尾返回-1；
 *   abstract int read(char buf[],int off,int len)  从输入流中将len个字符从buf的off位置读到buf中；
 *   boolean ready()                                判断流是否做好读的准备；       
 *   long skin(long n)                              跳过n个字符，返回实际跳过字符的数目；
 *   
 *   public BufferedReader(reader int ,int size)    参数为in的Reader对象，size为缓冲区容量      
 *   
 *   为了提高读取效率，通常将IntputStreamReader和BufferedStreamReader封装在一起，例如：
 *   InputStreamReader stdin = new InputStreamReader(System.in);
 *   BufferedStreamReader bufin = new BufferedStreamReader(stdin);
 *   或者：
 *   BufferedStreamReader bufin = new BufferedStreamReader(new InputStreamReader(System.in));
 *   (基于控制台的输入流)
 *   bufferedStreamReader()的readLine()方法：
 *   public String readLine()throws IOException;\n,\r看做一行结束；
 * ------------------------------------------------------------------------------------       
 *        
 *        
 *        
 *              
 *常用的字符输出流：
 *         BufferedWriter
 *Writer
 *         OutputStreamWriter  FileWriter(只有它可以指定文件夹,可以这样用Writer f = new FileWriter(。。。),需要抛出异常)
 * 
 *  abstract void close()                            关闭输出流；                  
 *  abstract void flush()                            强制将输出流中的字符串输出到指定输出装置；
 *  void write(int ch)                               写入一个字符串到流中；
 *  void write(char buf[])                           将一个完整的字符数珠写入到输出流中；
 *  void write(Strign s)                             写入一个字符串到输出流；
 *  abstract void write(char buf[],int off,int len)  从数组buf的off位置开始写入len个字符；                
 *  
 *  FileWriter(File file)
 *  FileWriter(File file,boolean append)
 *  FileWriter(String fileName)
 *  FileWriter(String fileName,boolean append)       append如果是false，就覆盖；
 * ------------------------------------------------------------------------------------                  
 *    
 *                     
 *                     
 *                     
 * 标准文件类；File                           /不需要抛出异常，其他的需要；
 * File                                   类对象可以对操作系统的文件进行管理，体现了跨平台不同文件的统一管理；
 * File(String path)   
 * File f1 = new File("hly\\hly.txt);     创建文件对象，使用相对路径，移植性较好
 * File f2 = new File("d:\\hly\\hly1");   创建目录对象，使用绝对路径,没有具体文件； 
 * File(String directoryPath,String name)
 * File f2 = new File("d:\\hly",hly.txt);
 * File(File dirobj,String filename)
 * File f4 = new File(f2,hly1.txt);
 * 
 * public boolen exists()                 判断目标文件是否存在；
 * public boolean isFile()                判断是不是文件；
 * public boolean isDirectory()           判断是不是目录；
 * public String getName()                返回文件名，文件路径信息被忽略；
 * public String getPath()                将整个路径的字符串返回；
 * public boolean isAbsolute()            判断抽象路径名是否为绝对路径名，c:\\1\\2\\2.txt(绝对路径名)
 * public String getAbsolute()            返回抽象路径的绝对路径名字字符串；
 * public long length()                   获取文件的长度；
 * public boolean canread()
 * public boolean canWrite()              获取文件的读取性；
 * public String [] list()                列出目录中的文件和子目录；
 * public File[] listFile()
 * public boolean rename(File newName)    重命名
 * public boolean delete()                删除文件或目录；
 * public boolean mkdir()                 创建目录；
 * public boolean mkdirs()                创建此抽象路径名；
 * File f1 = new File("Documents"+File.separator+"data.txt");表示是Documents\\data.txt.
 * File类使用一个静态实例变量separator(public static final String)保存了当前的目录分隔符；
 * ------------------------------------------------------------------------------------
 * 
 * 
 * 
 * 对文件进行读写：
 *  FileInputStream,FileOutputStream(字节流)
 *  FileReader,     FileWriter      (字符流)
 * -----------------------------------------------------------------------------------
 *
 * 
 * 
 * public calss RandowAccessFile extends Object implements DataOutput ,DataInput,Closeable
 * 随机读写文件，写入文件的任意位置,写入基本数据类型数据和字节数据，字符数据
 * RandomAccessFile(File file,String mode);      
 * RandomAccessFile(String name,String mode);    file 和name表示文件，mode标识对文件的操作方式
 * mode: r(只读) ,rw(读和写) , rws(对文件内容和文件头的更新同步到物理存储设备) , rwd(只内容)
 * 
 * public long length()throws IOException;       返回文件的长度；
 * public void seek(long pos)throws IOException; 将下次读写的位置定位到距离文件开始pos字节远的地方；
 * public long getFilePointer()throws IOException;得到当前读写的位置；
 * 
 * 
 */                    
	
	public static void main(String[] args)throws IOException {
		
	/*OutputStream os = new FileOutputStream("f:\\book\\hly1.txt");
	DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
	//OutputStreamWriter u = new OutputStreamWriter(new DataOutputStream(os));
	//DataOutputStream y = new DataOutputStream(new OutputStreamWriter(os));不可以这样用
	
	for(int i=0;i<10;i++){
	 dos.write(i);
	}	
	dos.writeChars("字符串");
	dos.writeUTF("输入的是什么2333");
	byte db[] = new byte[1024];
	db = "helloword".getBytes();
	dos.write(db);
	dos.writeChars("\n");
	byte db1[] = new byte[1024];
	db1 = "hello123".getBytes();
	dos.write(db1);
	dos.close();//没有输出不了
	*/
   /* InputStream is = new FileInputStream("f:\\book\\hly1.txt");
    DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
    int count = dis.available();
    System.out.println(count);
   //第一种输出读取方法；
    dis.read(db);
    for(int i=0;i<db.length;i++){
    	System.out.print((char)db[i]);
    }//可以读进去，输出显示乱码。
   
    //第二种输出读取方法：
    for(int i=0;i<count;i++){
    	int t = dis.read();
    	System.out.print((char)t);
    }
    System.out.println();
    //第三种输出读取方法：
    for(int i=0;i<count;i++){
    	char temp = (char)dis.read();
    	System.out.print(temp);
    }
    System.out.println();
    //第四种输出读取方法：
   int c;
   while((c=dis.read())!=-1){
	   c=dis.read();
	   System.out.print((char)c);
   }
  dis.close();
 */
	
	
	//字符输入输出流
	Writer fw = new FileWriter("f:\\book\\hly4.txt");
	BufferedWriter buf = new BufferedWriter(fw);
	//OutputStreamWriter isw = new OutputStreamWriter(new BufferedWriter(fw));不可以这样用
	//OutputStreamWriter i = new OutputStreamWriter(fw);
	/*buf.write("hello word");
	buf.newLine();*/
	for(int i=0;i<10;i++){
		buf.write(String.valueOf(i));
		//buf.write((char)i);
	}
	buf.close();
	
	Reader fr = new FileReader("f:\\book\\hly4.txt");
	BufferedReader br = new BufferedReader(fr);
	int v;
	while((v=br.read())!=-1){
		System.out.print((char)v);
	}
	/*String bs;
	while((bs=br.readLine())!=null){                                                     //一次读一行,循环2次 ，newLine（）不算一行读入的字符串，readLine()返回读到的字符串      
        System.out.println(bs);   
        }*/
	br.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}
