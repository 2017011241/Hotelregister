package util;
import java.sql.*;
public class DBconnect {
	 
	public static Connection connect(){ 
		String driverStr="com.mysql.jdbc.Driver";
		 String connStr; 
		 String dbusername="root"; 
		 String dbpassword="123456";
		connStr="jdbc:mysql://localhost:3306/eating?characterEncoding=gb2312"; 
		try{
			Class.forName(driverStr);
			Connection conn=(Connection) DriverManager.getConnection(connStr,dbusername,dbpassword);
			return conn;
	}catch(Exception ex){
		System.out.println("无法同数据库建立连接！");
		return null;}
	} 
	
//	public int executeUpdate(String s){ 
//		int result=0; 
//		try{ 
//			result=stmt.executeUpdate(s); 
//			}catch(Exception ex){ 
//				System.out.println("执行更新错误！"); 
//				} 
//		return result; 
//		} 
//	public ResultSet executeQuery(String s){ 
//		ResultSet rs=null;
//		try{
//			rs=stmt.executeQuery(s);
//			} catch(Exception ex){
//				System.out.println("执行查询错误！");
//				} 
//		return rs; 
//		} 
	
	public static void closeRs(ResultSet rs) {
		try {
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeCon(Connection con) {
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closePs(PreparedStatement ps) {
		try {
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public void close(){ 
//		try{ 
//			stmt.close();
//			conn.close(); 
//			} catch(Exception e){
//				e.printStackTrace();
//			}
//	} 

}

