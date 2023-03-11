package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String uname;
	String pass;
	String name1;
	PrintWriter pw;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String s1 = request.getParameter("username");
			String s2 = request.getParameter("password");
			pw = response.getWriter();
			ServletContext sc = request.getServletContext();
			HttpSession hs = request.getSession();
			hs.setAttribute("username", s1);

			Connection con = (Connection) sc.getAttribute("oral");
			PreparedStatement psmt = con.prepareStatement("select * from garibBank where uname=? and pass=? ;");
			psmt.setString(1, s1);
			psmt.setString(2, s2);
			ResultSet set = psmt.executeQuery();
			pw.println(
					"<style> .ss{text-align: center; }</style><html><body bgcolor= skyblue text=black>");
			while (set.next()) {
				uname = s1;
				pass = s2;
				name1 = set.getString("fname");
				hs.setAttribute("fname", name1);

			}
			if (uname == s1 && pass == s2) {
				// pw.println("Welcome");
				Thread.sleep(300);
				pw.println("<center><h1>Welcome to GribBank of India</h1></center>");
				pw.println("<h1>Select your options</h1> <al>");

				pw.println("<a href=CheckBalance> <li>Check Balance </li> </a><br>");
				pw.println("<a href=DepositServlet> <li >Deposit Amount </li> </a><br>");
				pw.println("<a href=WithDrawalServlet> <li> Withdrawal Amount</li> </a><br>");
				pw.println("<a href=MoneyTransfer> <li>Money Transfer</li> </a><br>");
				pw.println("<a href=AccDetails.jsp> <li>Accounts Details</li></a><br> ");
				//pw.println("<a href=MiniStatement> <li>Bank Statements</li></a><br>" );
				pw.println("</al>");
				

			} else  {
				
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
				pw.println("<center>Invalid UserName</h1></center>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("</body></html>");
	}


}
