package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class MiniStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc = request.getServletContext();
		Connection con = (Connection) sc.getAttribute("oral");
		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("username");
		String s2 = (String) hs.getAttribute("fname");
		PrintWriter pw = response.getWriter();
		hs.setAttribute("fname", s2);

		try {
			hs.setAttribute("username", s1);
			String query = "select * from " + s2 + " ;";
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet set=psmt.executeQuery();
			ResultSetMetaData data=set.getMetaData();
			int n=data.getColumnCount();
		pw.println("<html><body bgcolor=powderblue>");
		for(int i=1;i<=n;i++)
		{
			pw.print(data.getColumnName(i)+"\t");	
		}
		pw.println("<br>");
		while(set.next())
		{
			pw.println(set.getInt(1)+"\t"+set.getDate(2)+"\t"+set.getString(3)+"\t"+set.getDouble(4)+"<br>");
		}
		pw.println("<center><a href=Login.html><button>Log_Out </button> </a></center>");
		pw.println("</h1></body></html>");
		
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}


}
