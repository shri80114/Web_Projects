package GaribBank;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MoneyTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("username");
		hs.setAttribute("username", s1);
		String s2 = (String) hs.getAttribute("fname");
		hs.setAttribute("fname", s2);

		PrintWriter pw = response.getWriter();
		pw.println("<style>  body{background-color: powderblue; text-align: center; padding: 30;}</style>");
		pw.println(
				"<html><body><form method=\"post\" action=\"MoneyTrans\"><label>Enter Amount :</label>  <input type=\"text\" name=\"amount\"><br><br>");
		pw.println("<label >Enter Account Holder Name  </label><input type=\"text\" name=\"fname\" required><br><br>");
		pw.println("<label> Enter Account Number : </label><input type=\"text\" name=\"number\" required><br><br>");
		pw.println(" <input type=\"submit\"> <input type=\"reset\"></form>  </body></html>");

	}
}
