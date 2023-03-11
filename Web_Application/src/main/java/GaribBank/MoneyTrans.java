package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class MoneyTrans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Connection con = (Connection) sc.getAttribute("oral");
		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("username");
		String s2 = (String) hs.getAttribute("fname");
		PrintWriter pw = response.getWriter();

		String amt = request.getParameter("amount");
		String fname = request.getParameter("fname");
		String number = request.getParameter("number");
		double d = Double.parseDouble(amt);

		try {
			String query = " update garibBank set balance = balance - ? where uname=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setDouble(1, d);
			psmt.setString(2, s1);
			psmt.executeUpdate();
			// statement query
			String query1 = "insert into " + s2 + "(TransDate,type,amount) values(now(),'Debited',?);";
			PreparedStatement psmt1 = con.prepareStatement(query1);
			psmt1.setDouble(1, d);
			psmt1.executeUpdate();
			// Transfer balance account query
			int acc = Integer.parseInt(number);
			String query2 = "update garibBank  set balance=balance + ? where fname= ? and AccountNo=?";
			PreparedStatement psmt2 = con.prepareStatement(query2);
			psmt2.setDouble(1, d);
			psmt2.setString(2, fname);
			psmt2.setInt(3, acc);
			psmt2.executeUpdate();
			// statement query
			String query3 = "insert into " + fname + "(TransDate,type,amount) values(now(),'Credited',?);";
			PreparedStatement psmt3 = con.prepareStatement(query3);
			psmt3.setDouble(1, d);
			psmt3.executeUpdate();
			pw.println("<html><body bgcolor=powderblue><center>");
			pw.println("<h1>Transction is completed sucessfully</h1>");
			pw.println("<a href=CheckBalance><button>View Balance </button> </a>");
			pw.println("<a href=Login.html><button>Log_Out </button> </a>");
			
			pw.println("</center></body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
