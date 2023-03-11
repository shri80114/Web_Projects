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


public class Statement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// pw.println(s1);
		// pw.println(s2);

		try {
			String s1 = request.getParameter("date");
			String s2 = request.getParameter("date");
			PrintWriter pw = response.getWriter();
			HttpSession hs = request.getSession();
			String s3 = (String) hs.getAttribute("fname");
			ServletContext sc = getServletContext();
			Connection con = (Connection) sc.getAttribute("oral");
			String query = "select * from " + s3 + " where TransDate >= '?' and TransDate <='?';";
			// pw.println(query);

			PreparedStatement psmt = con.prepareStatement(query);
			// LocalDate date=LocalDate.parse(s1);
			// LocalDate date1=LocalDate.parse(s2);
			psmt.setString(1, s1);
			psmt.setString(2, s2);

			ResultSet set = psmt.executeQuery();
			while (set.next()) {
				pw.println(set.getInt("id") + " " + set.getDate("TransDate") + " ");
			}
			// select * from shrishail where TransDate >=' 2023-03-09' and TransDate
			// <='2023-03-10';
			pw.println("<html><body><center><a href=Login.html><button>Log_Out </button> </a></center>");
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
