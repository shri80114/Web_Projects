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


public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("username");
		String s2 = request.getParameter("password");
		String s3 = request.getParameter("pass");

		ServletContext sc = request.getServletContext();
		Connection con = (Connection) sc.getAttribute("oral");
PrintWriter pw=response.getWriter();
pw.println("<html><body bgcolor=tan>");
		if (s2.equals(s3)) {

			try {
				PreparedStatement psmt = con.prepareStatement("update sbi_bank set pass=? where email=?");
				psmt.setString(1, s3);
				psmt.setString(2, s1);
				psmt.executeUpdate();
				
				pw.println(" Sucessfully  changed  your changed");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			pw.println("<html></body>");
		}
	}

}
