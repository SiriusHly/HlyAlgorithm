package ���ݿ�;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

	public ConnectToDB() {
	}
	public static void main(String []args){
		//��ȡ���ݿ�����Ӷ���
		Connection con;
		//��ȡ���ݿ��Ԫ���ݣ�Ԫ�����а������ݿ���Ϣ�������б�ṹ��Ϣ��
		DatabaseMetaData meta = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("���س��������ɹ�");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("���س�������ʧ��");
		}
		
		
		try {
			String url = "jdbc:mysql://127.0.0.1:1433;DatabaseName=Northwind";//??
			String user = "root";
			String password = "roof";
			con=DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�");
			meta=con.getMetaData();//??
			System.out.println("���ӵ����ݿ⣻"+meta.getURL());
			//ȡ�ü����������������
			System.out.println("Driver:"+meta.getDriverName());
			System.out.println("���ݿ�汾:"+meta.getDriverVersion());
		} catch (SQLException e) {
			System.out.println("���ݿ������쳣");
			e.printStackTrace();
		}
		
		
		
	}

}
