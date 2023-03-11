
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<style>
center {
	padding: 20px;
}

body {
	padding: 30px;
}
</style>

<body bgcolor=gold>



	<%
	ServletContext sc = request.getServletContext();
	Connection con = (Connection) sc.getAttribute("oral");
	HttpSession hs = request.getSession();
	String s1 = (String) hs.getAttribute("fname");

	try {
		String query = "select * from garibBank where fname=?";

		PreparedStatement psmt = con.prepareStatement(query);
		psmt.setString(1, s1);
		ResultSet set = psmt.executeQuery();
		while (set.next()) {
			out.println("<center><h1>GaribBank Of India</h1><br></center>");

			out.println("<h1>Accounts Details </h1>");
			out.println("<h2>Account Holder Name : " + set.getString("fname") + " " + set.getString("lname") + "</h2>");
			out.println("<h2>Address : " + set.getString("Adderess") + "</h2>");
			out.println("<h2>Mobile Number : " + set.getString("Mob_No") + "</h2>");
			out.println("<h2>Account  Number: " + set.getString("AccountNo") + "</h2>");
			out.println("<h2>Account Balance: " + set.getString("balance") + "</h2>");
			out.println("<h2>User Name: " + set.getString("uname") + "</h2>");
			out.println("<h2>Registerd Email_Id : " + set.getString("EmailId") + "</h2>");

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>



</body>
</html>