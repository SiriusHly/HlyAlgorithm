package FileTest;

public class FileText1 {
/*
 * ���ߣ�hly��
 */
/*���õ����ֽ�������:
 *             FileInputStream  (��ȡ�ļ�������)
 *InputStream                    DataInputStream    (���Զ�ȡ�������͵�����)
 *             FilterInputStream(�����ɹ���������)
 *                               BufferedInputStream(��߶�ȡ�ٶ�)
 *                                           
 *  int read()                                          ��ȡһ���ֽڣ��������ĩ�˷���-1��
 *  int read(byte b [] )                                �������������ֽ������У����ض�����ֽ�����
 *  int read(byte b [],int off,int len)                 ���������ж�ȡlen���ַ���b�У����ĵ�һ�� �ֽڷŵ�off�������off+len>b��length���׳�IndexOutputBoundsException;                                                
 *  long skin(long n)                                   ��������������n���ֽڣ������������ֽ�����������read��������ȡn+1�� �ֽڣ�*                                                     
 *  abstract void close()                               �ر�������
 *  public BufferedInputStream(intputStream in,int size)inΪ�ײ��������� sizeΪ��������С��
 *                                                   
 *  File file = new File("...");
 *  FileInputStream fis = new FileInputStream(file);    ͨ����һ��ʵ��File��Ķ���file������һ��FileInputStream
 *  
 *  InputStream fis = new FileInputStream("fileInputStreamDemo.java");
 *                                                       ͨ��·����������һ��FileInputStream�Ķ���;
 *  DataInputStream������з���������read��ͷ��readByte(); readLong(); readUTF();               
 *-----------------------------------------------------------------------------------------
 *                
 *             
 *���õ��ֽ���������������ڼ�����ڴ��е�����������ⲿ�豸
 *              FileOutputStream(д���ļ������)
 *OutputStream                     DataOutputStream    (д���κη���Java�������͵���Ϣ)
 *              FilterOutputStream
 *                                 BufferedOutputStream(Ϊ����ṩ���������)
 * 
 *  void write(int b)                    ������b�ĵͰ�λд���������
 *  void write(byte b[])                 ���ֽ�����д�������
 *  void write(byte b[],int off,int size)���ֽ�b��off����ʼ�������д��len���ֽڣ�
 *  abstract void flush()                ǿ�ƽ�����������ڻ�����������д��Ŀ������Դ��
 *  public BufferedOutputStream(OutputStream out,int size)...
 * 
 *  FileOutputStream(File file);
 *  FileOutput(String pathName,boolean append);
 *  DataOutputStream                     ������������д������Ŀ�ĵأ�
 *  writeBoolean(boolean v)
 *  writeChar(int v)
 *  writeChars(String s)                 ���ַ���s�����е��ַ���˳��д���������ÿ���ַ������ֽڣ�
 * ---------------------------------------------------------------------------------------
 * 
 * 
 * 
 *���õ��ַ���������
 *         BufferedReader   (����readLine()�����Ļ��������ַ���)
 *Reader   
 *                                                 FileReader(���ļ���������������ȡ�ַ��ļ�)
 *         InputStreamReader(���ֽ�������ת��Ϊ�ַ������������ֽ������ַ�����������)
 *           
 *   abstract void close()                          �ر���������                           
 *   int read();                                    ����������ȡһ���ַ�����������ļ���β������-1��
 *   int read (char buf[])                          ���������н�ָ���������ַ����뵽����buf�У����ض�ȡ�ַ�����Ŀ���ﵽ��β����-1��
 *   abstract int read(char buf[],int off,int len)  ���������н�len���ַ���buf��offλ�ö���buf�У�
 *   boolean ready()                                �ж����Ƿ����ö���׼����       
 *   long skin(long n)                              ����n���ַ�������ʵ�������ַ�����Ŀ��
 *   
 *   public BufferedReader(reader int ,int size)    ����Ϊin��Reader����sizeΪ����������      
 *   
 *   Ϊ����߶�ȡЧ�ʣ�ͨ����IntputStreamReader��BufferedStreamReader��װ��һ�����磺
 *   InputStreamReader stdin = new InputStreamReader(System.in);
 *   BufferedStreamReader bufin = new BufferedStreamReader(stdin);
 *   ���ߣ�
 *   BufferedStreamReader bufin = new BufferedStreamReader(new InputStreamReader(System.in));
 *   (���ڿ���̨��������)
 *   bufferedStreamReader()��readLine()������
 *   public String readLine()throws IOException;\n,\r����һ�н�����
 * ------------------------------------------------------------------------------------       
 *        
 *        
 *        
 *              
 *���õ��ַ��������
 *         BufferedWriter
 *Writer
 *         OutputStreamWriter  FileWriter
 * 
 *  abstract void close()                            �ر��������                  
 *  abstract void flush()                            ǿ�ƽ�������е��ַ��������ָ�����װ�ã�
 *  void write(int ch)                               д��һ���ַ��������У�
 *  void write(char buf[])                           ��һ���������ַ�����д�뵽������У�
 *  void write(Strign s)                             д��һ���ַ������������
 *  abstract void write(char buf[],int off,int len)  ������buf��offλ�ÿ�ʼд��len���ַ���                
 *  
 *  FileWriter(File file)
 *  FileWriter(File file,boolean append)
 *  FileWriter(String fileName)
 *  FileWriter(String fileName,boolean append)       append�����false���͸��ǣ�
 * ------------------------------------------------------------------------------------                  
 *    
 *                     
 *                     
 *                     
 * ��׼�ļ��ࣻFile
 * File                                   �������ԶԲ���ϵͳ���ļ����й��������˿�ƽ̨��ͬ�ļ���ͳһ����
 * File(String path)   
 * File f1 = new File("hly\\hly.txt);     �����ļ�����ʹ�����·������ֲ�ԽϺ�
 * File f2 = new File("d:\\hly\\hly1");   ����Ŀ¼����ʹ�þ���·��,û�о����ļ��� 
 * File(String directoryPath,String name)
 * File f2 = new File("d:\\hly",hly.txt);
 * File(File dirobj,String filename)
 * File f4 = new File(f2,hly1.txt);
 * 
 * public boolen exists()                 �ж�Ŀ���ļ��Ƿ���ڣ�
 * public boolean isFile()                �ж��ǲ����ļ���
 * public boolean isDirectory()           �ж��ǲ���Ŀ¼��
 * public String getName()                �����ļ������ļ�·����Ϣ�����ԣ�
 * public String getPath()                ������·�����ַ������أ�
 * public boolean isAbsolute()            �жϳ���·�����Ƿ�Ϊ����·������c:\\1\\2\\2.txt(����·����)
 * public String getAbsolute()            ���س���·���ľ���·�������ַ�����
 * public long length()                   ��ȡ�ļ��ĳ��ȣ�
 * public boolean canread()
 * public boolean canWrite()              ��ȡ�ļ��Ķ�ȡ�ԣ�
 * public String [] list()                �г�Ŀ¼�е��ļ�����Ŀ¼��
 * public File[] listFile()
 * public boolean rename(File newName)    ������
 * public boolean delete()                ɾ���ļ���Ŀ¼��
 * public boolean mkdir()                 ����Ŀ¼��
 * public boolean mkdirs()                �����˳���·������
 * File f1 = new File("Documents"+File.separator+"data.txt");��ʾ��Documents\\data.txt.
 * File��ʹ��һ����̬ʵ������separator(public static final String)�����˵�ǰ��Ŀ¼�ָ�����
 * ------------------------------------------------------------------------------------
 * 
 * 
 * 
 * ���ļ����ж�д��
 *  FileInputStream,FileOutputStream(�ֽ���)
 *  FileReader,     FileWriter      (�ַ���)
 * -----------------------------------------------------------------------------------
 *
 * 
 * 
 * public calss RandowAccessFile extends Object implements DataOutput ,DataInput,Closeable
 * �����д�ļ���д���ļ�������λ��,д����������������ݺ��ֽ����ݣ��ַ�����
 * RandomAccessFile(File file,String mode);      
 * RandomAccessFile(String name,String mode);    file ��name��ʾ�ļ���mode��ʶ���ļ��Ĳ�����ʽ
 * mode: r(ֻ��) ,rw(����д) , rws(���ļ����ݺ��ļ�ͷ�ĸ���ͬ��������洢�豸) , rwd(ֻ����)
 * 
 * public long length()throws IOException;       �����ļ��ĳ��ȣ�
 * public void seek(long pos)throws IOException; ���´ζ�д��λ�ö�λ�������ļ���ʼpos�ֽ�Զ�ĵط���
 * public long getFilePointer()throws IOException;�õ���ǰ��д��λ�ã�
 * 
 * 
 */                    
	
	public static void main(String[] args) {
System.out.println("dawdaw");
	}

}
