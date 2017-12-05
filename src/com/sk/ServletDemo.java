package com.sk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
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
		PrintWriter out = response.getWriter();
		//out.println();
		out.println("<HTML>");
		  out.println("<HEAD>");
		  out.println("<TITLE>Servlet Testing</TITLE>");
		  out.println("</HEAD>");
		  out.println("<BODY>");
		  out.println("complete");
		  out.println("</BODY>");
		  out.println("</HTML>");
		PrintWriter pw=response.getWriter();
		//PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession();
		Cookie co[]=request.getCookies();		
		for(Cookie pri:co)
		{
			pw.println(pri.getName()+" value is "+pri.getValue()+"<br>");
		}
		String nn=(String)hs.getAttribute("us");
		pw.println("Welcome To Web page....."+nn);
	}

}
