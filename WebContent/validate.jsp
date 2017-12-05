<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#babacd">
		<%! String una,pwd; %>

		<%
			una=request.getParameter("username");
			pwd=request.getParameter("password");
			//session.setAttribute("us", una);
			//Cookie co=new Cookie("user","Raffic");
			//response.addCookie(co);
			
			try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SHAIKH SADI", "01960171418");
				 ServletContext sc=getServletContext();
				// Connection con=//(Connection)sc.getAttribute("myconn");
				 PreparedStatement ps=con.prepareStatement("select * from STUDENT_REG where NAME=? and PASS=?");
				 ps.setString(1,una);
				 ps.setString(2,pwd);
				 ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 RequestDispatcher rd=request.getRequestDispatcher("/UserRegisterPage.jsp");
					 rd.forward(request, response);
				 }
				 else
				 {
					 %>
					 <Font color=red size=10>Login Failed... Try Again</Font><br>
					 <%@include file="index.jsp"%>
					 <%
				 }
			}catch(Exception ex)
			{
				System.out.println("Error in validate Page:::"+ex);
			}
		
		
		%>

</body>
</html>