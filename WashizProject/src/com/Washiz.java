package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import model.MvcClass;
import POJO.Address;
import POJO.CardInfo;
import POJO.Logdetail;
import POJO.Orders;
import POJO.User;


@WebServlet("/Washiz.do")
public class Washiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    MvcClass m = new MvcClass();
	    String submitValue = request.getParameter("submit");
	    
	    
	    if (submitValue.equalsIgnoreCase("signin")) {
	    	String fname="",lname="";
	    	int empid=0;
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Logdetail u = new Logdetail();
			u.setPassword(password);
			
			u.setUsername(username);
			try{
			ResultSet rs = m.loginfunction(u);
			if(rs.isBeforeFirst())
			{	
				while (rs.next()) { 
					 fname  = rs.getString("fname");
					 lname  = rs.getString("lname");
					 empid  = rs.getInt("empid");
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("user", u.getUsername());
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("empid", empid);
				response.sendRedirect("dashboard.jsp");
			}
			
			else{
				request.setAttribute("errmsg", "Incorrect Login Details");
				request.getRequestDispatcher("signin.jsp").forward(request, response);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}	    
	    
	    
	    if (submitValue.equalsIgnoreCase("registration")
				|| submitValue.equalsIgnoreCase("updateprofile")) {
			
	    	int empid = 0;
			if (request.getParameter("empid") != null) {
				empid = Integer.parseInt(request.getParameter("empid"));
			}
	    	String username = request.getParameter("username");
	    	String password = request.getParameter("password");
	    	String fname = request.getParameter("fname");
	    	String lname = request.getParameter("lname");
	    	long mobile = Long.parseLong(request.getParameter("mobile"));
	    	long zipcode = Long.parseLong(request.getParameter("zipcode"));
	    	String gender = request.getParameter("gender");
	    	
	  		
	    	User u = new User();
	    	if (empid != 0)
			u.setEmpid(empid);
			u.setUsername(username);
			u.setPassword(password);
			u.setFname(fname);
			u.setLname(lname);
			u.setMobile(mobile);
			u.setGender(gender);
			u.setZipcode(zipcode);
	    	
			if (submitValue.equalsIgnoreCase("registration")) {	
			int i = m.register(u);
			if (i != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", u.getUsername());
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("empid", empid);
				request.getRequestDispatcher("")
				.forward(request, response);
			}
			}
			
			if (submitValue.equalsIgnoreCase("updateprofile")) {
				int i = m.update(u);
				if (i != 0) {
					request.getRequestDispatcher("Washiz.do?submit=viewprofile")
							.forward(request, response);
			
			}
			
	    }
	    }
	    
		
		if(submitValue.equalsIgnoreCase("addaddress")){
			
			
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			String name = request.getParameter("name");
	    	String street = request.getParameter("street");
	    	String hnumber = request.getParameter("hnumber");
	    	String address = request.getParameter("address");
	    	long zipcode = Long.parseLong(request.getParameter("zipcode"));
	    	String city = request.getParameter("city");
	    	
	    	
			Address u=new Address();
			u.setEmpid(empid);
			u.setName(name);
			u.setStreet(street);
			u.setHnumber(hnumber);
			u.setAddress(address);
			u.setZipcode(zipcode);
			u.setCity(city);
			
			int i = m.addaddress(u, empid);
			if (i != 0) {
				
				response.sendRedirect("Washiz.do?submit=viewaddresses");
			}
			
	    }

		if(submitValue.equalsIgnoreCase("viewaddresses")) {
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			ArrayList<Address> al = m.viewaddress(empid);
			request.setAttribute("addressdata", al);
			request.getRequestDispatcher("address.jsp").forward(request, response);
		}
		
		
		if(submitValue.equalsIgnoreCase("getaddressname")) {
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			ArrayList<Address> al = m.getaddressname(empid);
			request.setAttribute("addressnamedata", al);
			request.getRequestDispatcher("book-a-ninja.jsp").forward(request, response);
		}
		
		if(submitValue.equalsIgnoreCase("viewprofile")) {
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			ArrayList<User> al = m.viewprofile(empid);
			request.setAttribute("profiledata", al);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		

		if(submitValue.equalsIgnoreCase("addcardinfo")){
			
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			
			String type = request.getParameter("type");
			
			String holdername = request.getParameter("holdername");
		
			int number1 = Integer.parseInt(request.getParameter("number1"));
			int number2 = Integer.parseInt(request.getParameter("number2"));
			int number3 = Integer.parseInt(request.getParameter("number3"));
			int number4 = Integer.parseInt(request.getParameter("number4"));
	    	
			int expmonth = Integer.parseInt(request.getParameter("expmonth"));
			int expyear = Integer.parseInt(request.getParameter("expyear"));
	    	
			CardInfo u = new CardInfo();
			u.setType(type);
			u.setHoldername(holdername);
			u.setExpmonth(expmonth);
			u.setExpyear(expyear);
			u.setNumber1(number1);
			u.setNumber2(number2);
			u.setNumber3(number3);
			u.setNumber4(number4);
			u.setEmpid(empid);
			
			int i = m.addcardinfo(u);
			if (i != 0) {
				
				response.sendRedirect("Washiz.jsp?submit=viewcardinfo");
			}
			
	    }

		
		if(submitValue.equalsIgnoreCase("viewcardinfo")) {
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			ArrayList<CardInfo> al = m.viewcardinfo(empid);
			request.setAttribute("cardinfodata", al);
			request.getRequestDispatcher("cardinfo.jsp").forward(request, response);
		}
		
		
		
		if(submitValue.equalsIgnoreCase("neworder")) {
			HttpSession session = request.getSession(false);
			
			String pdate = request.getParameter("pickupdate");
			//Date pickupdate = Date.valueOf(pdate);
			
			String ddate = request.getParameter("deliverydate");
			//Date deliverydate = Date.valueOf(ddate);
			
			Orders o = new Orders();
			o.setPickuptime(request.getParameter("pickuptime"));
			o.setPickupdate(Date.valueOf(pdate));
			o.setPickupaddress(request.getParameter("pickupaddress"));
			o.setDeliverytime(request.getParameter("deliverytime"));
			o.setDeliveryaddress(request.getParameter("deliveryaddress"));
			o.setEmpid( (int) session.getAttribute("empid"));
			o.setPrice(Integer.parseInt(request.getParameter("price")));
			o.setDeliverydate(Date.valueOf(ddate));
			
			int i = m.addorderinfo(o);
			if(i==1)
			{
				request.getRequestDispatcher("Washiz.do?submit=orderhistory").forward(request, response);
		    }

		
	}

		if(submitValue.equalsIgnoreCase("orderhistory")) {
	
			HttpSession session = request.getSession(false);
			int empid = (int) session.getAttribute("empid");
			ArrayList<Orders> al = m.vieworderhistory(empid);
			request.setAttribute("orderinfodata", al);
			request.getRequestDispatcher("historical-orders.jsp").forward(request, response);
	
		
		}
		
		
		
	}
	
}
