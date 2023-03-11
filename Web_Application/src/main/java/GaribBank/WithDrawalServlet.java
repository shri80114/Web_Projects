package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class WithDrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("username");
	String s2=(String)hs.getAttribute("fname");
		hs.setAttribute("username", s1);
		hs.setAttribute("fname", s2);
		
		PrintWriter pw=response.getWriter();
		//pw.println(s1);
		pw.println("<style>  body{background-color: powderblue; text-align: center;}</style>");
		pw.println("<html><body><form method=\"post\" action=\"WithDraw\"> <h1>Withdrwal page</h1>Enter Amount <input type=\"text\" name=\"amount\"><br><br>");
		pw.println(" <input type=\"submit\"> <input type=\"reset\"> </form>  </body></html>");
	}
}
