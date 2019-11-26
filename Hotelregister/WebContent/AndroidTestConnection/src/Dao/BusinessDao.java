package Dao;
import util.*;
import model.*;
import java.sql.*;
public class BusinessDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public BusinessDao() {};
	
	public int addBusiness()  {
		int i = 0;
		con = DBconnect.connect();
		try {
			String sql = "insert into business(name, password, tel) values('lihang', '123456', '15037232227')";
			ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBconnect.closeCon(con);
			DBconnect.closePs(ps);
		}
		
		return i;	
	}
	
	public Business findBusinessByTel(String tel) {
		Business business = null;
		con = DBconnect.connect();
		try {
			String sql = "select * from business where tel = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				business = new Business();
				business.setId(rs.getInt("id"));
				business.setName(rs.getString("name"));
				business.setPassword(rs.getString("password"));
				business.setTel(rs.getString("tel"));
			}
			return business;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("查询失败");
			return null;
		}finally {
			DBconnect.closeCon(con);
			DBconnect.closePs(ps);
			DBconnect.closeRs(rs);
		}
		
	}
	
	public boolean checkLogin(Business business) {
		con = DBconnect.connect();
		try {
			String sql = "select * from business where tel = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, business.getTel());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				if(business.getTel().equals(rs.getString("tel")) && business.getPassword().equals(rs.getString("password")))
					return true;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("查询失败");
			return false;
		}finally {
			DBconnect.closeCon(con);
			DBconnect.closePs(ps);
			DBconnect.closeRs(rs);
		}
	}
}
