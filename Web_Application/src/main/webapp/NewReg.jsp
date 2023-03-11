<!DOCTYPE html>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>

<body bgcolor=sandybrown;>

	<%!String gen;%>

	<%
	ServletContext sc = request.getServletContext();
	Connection con = (Connection) sc.getAttribute("oral");
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");

	String male = request.getParameter("male");
	String female = request.getParameter("female");

	String email = request.getParameter("email");
	String mob = request.getParameter("mobile");
	String add = request.getParameter("add");
	String uname = request.getParameter("uname");
	String pass = request.getParameter("pass");
	if (!male.equals("null") || !female.equals("null")) {
		gen = male;
	}

	try {

		PreparedStatement psmt = con.prepareStatement(
		"insert into garibBank(fname,lname,gender,emailId,mob_no,Adderess,uname,pass,balance) values(?,?,?,?,?,?,?,?,0)");
		psmt.setString(1, fname);
		psmt.setString(2, lname);
		psmt.setString(3, gen);
		psmt.setString(4, email);
		psmt.setString(5, mob);
		psmt.setString(6, add);
		psmt.setString(7, uname);
		psmt.setString(8, pass);
		psmt.executeUpdate();
		out.println("Account will created ");
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>