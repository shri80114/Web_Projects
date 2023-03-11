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


public class Dposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ServletContext sc = request.getServletContext();
			Connection con = (Connection) sc.getAttribute("oral");
			HttpSession hs = request.getSession();
			String s1 = (String) hs.getAttribute("username");
			String s2 = (String) hs.getAttribute("fname");

			PrintWriter pw = response.getWriter();
			pw.println("<html><body bgcolor=powderblue>");
			String amt = request.getParameter("amount");
			// Update balance Query
			String query = "update garibBank set balance =balance + ? where uname=?;";

			PreparedStatement psmt = con.prepareStatement(query);
			double d = Double.parseDouble(amt);
			psmt.setDouble(1, d);
			psmt.setString(2, s1);
			psmt.executeUpdate();
			// Ministatements query
			String query1 = "insert into " + s2 + "(TransDate,type,amount) values(now(),'Credited',?);";
			PreparedStatement psmt1 = con.prepareStatement(query1);
			psmt1.setDouble(1, d);
			psmt1.executeUpdate();
			pw.println("<h1>GaribBank Acct "+d+"Credited</h1>");
			pw.println("<center><a href=CheckBalance><button>View Balance </button> </a></center>");
			pw.println("<center><a href=Login.html><button>Log_Out </button> </a></center>");
			
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
