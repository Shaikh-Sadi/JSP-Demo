
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import javax.swing.JOptionPane;


public class ListDemo implements ServletContextListener 
{
	Connection con;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SHAIKH SADI", "01960171418");
			//Context initContext = new InitialContext();
			//Context envContext = (Context) initContext.lookup("java:comp/env");
			//DataSource ds = (DataSource) envContext.lookup("jdbc/MyDB");
			//con = ds.getConnection();
			ServletContext sc=sce.getServletContext();
			sc.setAttribute("myconn", con);
			//JOptionPane.showMessageDialog(null, "Contect Added..");
		}catch(Exception ex)
		{
			System.out.println("Error in ListDemo::"+ex);
		}
	}

}
