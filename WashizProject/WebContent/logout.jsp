<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		session.removeAttribute("user");
     	session.removeAttribute("fname");
	    session.removeAttribute("lname");
	    session.removeAttribute("empid");
		session.invalidate();
		request.setAttribute("errmsg", "Successfully Logged Out!");
		response.sendRedirect("signin.jsp");
		//request.setAttribute(logout, Successfull);
	%>
</body>
</html>