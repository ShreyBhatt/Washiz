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
		session.setAttribute("username", null);
		session.setAttribute("fname", null);
		session.setAttribute("lname", null);
		session.setAttribute("empid", null);
		session.invalidate();
		response.sendRedirect("signin.jsp");
		//request.setAttribute(logout, Successfull);
	%>
</body>
</html>