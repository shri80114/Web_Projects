package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WithDraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static double bmt;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext sc = request.getServletContext();
			Connection con = (Connection) sc.getAttribute("oral");
			HttpSession hs = request.getSession();
			String s1 = (String) hs.getAttribute("username");
			String s2 = (String) hs.getAttribute("fname");

			PrintWriter pw = response.getWriter();
			pw.println("<html><body bgcolor=Orange>");
			String amt = request.getParameter("amount");
			double d = Double.parseDouble(amt);
			String q = "select * from garibBank where fname='" + s2 + "';";

			Statement sta = con.createStatement();
			ResultSet set = sta.executeQuery(q);

			while (set.next()) {
				bmt = set.getDouble("balance");
			}

			if (d < bmt) {
				// Update balance Query
				String query = "update garibBank set balance =balance - ? where uname=?;";

				PreparedStatement psmt = con.prepareStatement(query);

				psmt.setDouble(1, d);
				psmt.setString(2, s1);
				psmt.executeUpdate();
				// Ministatements query
				String query1 = "insert into " + s2 + "(TransDate,type,amount) values(now(),'Debited',?);";
				PreparedStatement psmt1 = con.prepareStatement(query1);
				psmt1.setDouble(1, d);
				psmt1.executeUpdate();
				pw.println("<h1>GaribBank Acct debited for Rs " + d + "</h1><br><br>");
				pw.println("<br><a href=CheckBalance><button>View Balance </button> </a>");
				pw.println("<center><a href=Login.html><button>Log_Out </button> </a></center>");
				

			} else {
				pw.println("<h1>Insufficient Balance</h1>");
				pw.println("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
