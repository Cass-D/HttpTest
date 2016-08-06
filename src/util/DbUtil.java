package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author 
 *
 */
public class DbUtil {
	String driverClass="org.gjt.mm.mysql.Driver";
	String url = "jdbc:mysql://localhost/ordersys?user=root&password=x5&useUnicode=true&characterEncoding=gb2312";
	String username="root";
	String password="x5";
	Connection con=null;
	public Connection getCon(){
		try {
			Class.forName(driverClass); //加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url); //建立连接conn
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("233");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败!");
		}
	}
}
