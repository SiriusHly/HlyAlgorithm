package sql;

import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class sql {  
  
    public static void main(String[] args) {  
        Connection con;  
        DatabaseMetaData meta=null;  
  
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();  
            System.out.println("���������ɹ�");  
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {  
  
            e1.printStackTrace();  
            System.out.println("��������ʧ��");  
        }  
  
  
  
        try {  
            String uri = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MyDataBase";  
            String user="sa";  
            String password="123456";  
            con= DriverManager.getConnection(uri,user,password);  
            System.out.println("�������ݿ�ɹ�");  
            meta =  con.getMetaData();  
            System.out.println("���ӵ����ݿ⣺"+meta.getURL()+"\n"+"Driver:"+meta.getDriverName()+"\n"+"Version��"+meta.getDriverVersion());  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
        }  
  
  
    }  
  
}  
