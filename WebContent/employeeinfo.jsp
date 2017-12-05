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
<body>
<div class=" " style="color:red;">
	<table border="1" align="CENTER">
		<tr>
			<td>Emp Name</td><td>Emp Age</td><td>Emp City</td>
		</tr>
		<%
			try{
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "shaikh sadi", "01960171418");
				 // Connection con=DataConn.getConn();
				//ServletContext sc=getServletContext();
				//Connection con=(Connection)sc.getAttribute("myconn");
				PreparedStatement ps=con.prepareStatement("select * from STUDENT_REG");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					%>
						<tr>
					  <td style="color:green;"><%= rs.getString(1) %></td>
					  <td style="color:blue;"><%= rs.getInt(2) %></td>
					  <td style="color:green;"><%= rs.getString(3) %></td>
				
					  	</tr>
					<% 
				}
				
			}catch(Exception ex){
				System.out.println("Error in employeeinfo::"+ex);				
			}
		%>
		</table>
		</div>
</body>
</html>