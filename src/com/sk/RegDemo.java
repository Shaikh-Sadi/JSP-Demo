package com.sk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class RegDemo
 */
@WebServlet("/RegDemo")
public class RegDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String na=request.getParameter("na");
		int age=Integer.parseInt(request.getParameter("ag"));
		String pwd=request.getParameter("pwd");
		
		try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "shaikh sadi", "01960171418");
			  PreparedStatement ps=con.prepareStatement("insert into STUDENT_REG values(?,?,?)");
			  ps.setString(1, na);
			  ps.setInt(2,age);
			  pw.println("<font color=red size=5>clear</font>");
			  ps.setString(3, pwd);
			  ps.execute();
			  pw.println("<font color=red size=5>Registration Successfully...</font>");
			  RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			  rd.include(request, response);
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
