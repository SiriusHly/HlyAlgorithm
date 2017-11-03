package 数据库;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

	public ConnectToDB() {
	}
	public static void main(String []args){
		//获取数据库的连接对象
		Connection con;
		//获取数据库的元数据，元数据中包含数据库信息库中所有表结构信息；
		DatabaseMetaData meta = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("加载程序驱动成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("加载程序驱动失败");
		}
		
		
		try {
			String url = "jdbc:mysql://127.0.0.1:1433;DatabaseName=Northwind";//??
			String user = "root";
			String password = "roof";
			con=DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
			meta=con.getMetaData();//??
			System.out.println("连接的数据库；"+meta.getURL());
			//取得加载驱动程序的名称
			System.out.println("Driver:"+meta.getDriverName());
			System.out.println("数据库版本:"+meta.getDriverVersion());
		} catch (SQLException e) {
			System.out.println("数据库连接异常");
			e.printStackTrace();
		}
		
		
		
	}

}
