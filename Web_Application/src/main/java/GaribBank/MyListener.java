package GaribBank;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class MyListener implements ServletContextListener {

	Connection con;

	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netbanking", "root", "1234");
			ServletContext sc = sce.getServletContext();
			sc.setAttribute("oral", con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
