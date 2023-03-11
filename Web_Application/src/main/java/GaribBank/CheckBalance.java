package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("username");
		
		ServletContext sc=request.getServletContext();
		Connection con=(Connection)sc.getAttribute("oral");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body bgcolor=powderblue text=blue>");
		//pw.println(s1);
		if (s1 != null) {
			try {

				PreparedStatement psmt = con.prepareStatement("select balance from garibBank where uname=?;");
				psmt.setString(1, s1);
				ResultSet set = psmt.executeQuery();

				while (set.next()) {
					pw.println("<h1>Your account balance is : " + set.getDouble("balance") + "</h1>");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		pw.println("</body></html>");
	}



}
