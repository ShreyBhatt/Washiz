package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import POJO.Logdetail;
import POJO.Orders;
import POJO.User;
import util.DBhelper;

@WebServlet("/MvcClass")
public class MvcClass {

	Connection con = DBhelper.getConnection();

	public ResultSet loginfunction(Logdetail u) {
		ResultSet rs=null;
		PreparedStatement ps;
		try {
			ps= con.prepareStatement("select * from admin where username=? AND binary password = ?");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public ArrayList<User> listofusers() {
		ArrayList<User> al = new ArrayList<User>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				User u = new User();
				u.setUsername(rs.getString(1));
				u.setFname(rs.getString(3));
				u.setLname(rs.getString(4));
				u.setMobile(rs.getInt(5));
				u.setZipcode(rs.getInt(6));
				u.setEmpid(rs.getInt(8));
				al.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;

	}

	
	
	
/*	public int register(User u) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into user values (?,?,?,?,?,?,?,null)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getLname());			
			ps.setLong(5,  u.getMobile());
			ps.setLong(6,  u.getZipcode());
			ps.setString(7, u.getGender());
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	



	public int addaddress(Address u, int empid) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into address values (?,?,?,?,?,?,?)");
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getStreet());
			ps.setString(3, u.getHnumber());
			ps.setString(4, u.getAddress());
			ps.setLong(5, u.getZipcode());
			ps.setString(6, u.getCity());
			ps.setInt(7, empid);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}


	public ArrayList<Address> viewaddress(int empid) {
		ArrayList<Address> al = new ArrayList<Address>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select name,hnumber,street,address,zipcode,city from address where empid=?");
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Address a = new Address();
				a.setName(rs.getString(1));
				a.setHnumber(rs.getString(2));
				a.setStreet(rs.getString(3));
				a.setAddress(rs.getString(4));
				a.setZipcode(rs.getInt(5));
				a.setCity(rs.getString(6));
				al.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;

	
	}


	

	public int update(User u) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update user set username=? , password = ? , fname= ? ,"
					+ " lname= ? , mobile= ?, zipcode= ?, gender= ? where empid = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getLname());			
			ps.setLong(5,  u.getMobile());
			ps.setLong(6,  u.getZipcode());
			ps.setString(7, u.getGender());
			ps.setInt(8, 1);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}	
	

	public int addcardinfo(CardInfo u) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into cardinfo values (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, u.getEmpid());
			ps.setString(2, u.getType());
			ps.setString(3, u.getHoldername());
			ps.setInt(4, u.getNumber1());
			ps.setInt(5, u.getNumber2());
			ps.setInt(6, u.getNumber3());
			ps.setInt(7, u.getNumber4());
			ps.setInt(8, u.getExpmonth());
			ps.setInt(9, u.getExpyear());
			
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}


	public ArrayList<CardInfo> viewcardinfo(int empid) {
		ArrayList<CardInfo> al = new ArrayList<CardInfo>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from cardinfo where empid=?");
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				CardInfo u = new CardInfo();
				u.setType(rs.getString(2));
				u.setHoldername(rs.getString(3));
				u.setNumber1(rs.getInt(4));
				u.setNumber4(rs.getInt(7));
				u.setExpmonth(rs.getInt(8));
				u.setExpyear(rs.getInt(9));
				al.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;

	
	}


	public ArrayList<Address> getaddressname(int empid) {
	
		ArrayList<Address> al = new ArrayList<Address>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select name from address where empid=?");
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Address a = new Address();
				a.setName(rs.getString(1));				
				al.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;

		
	}



	

	public int delete(int id) {
		PreparedStatement ps;
		int i = 0;
		try {

			ps = con.prepareStatement("delete from register where id=?");
			ps.setInt(1, id);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<User> selectParticular(int id) {
		ArrayList<User> al = new ArrayList<User>();

		try {
			PreparedStatement ps = con
					.prepareStatement("select * from register where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setGender(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCourse(rs.getString(5));
				u.setHobbies(rs.getString(6));
				al.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}


	


*/}
