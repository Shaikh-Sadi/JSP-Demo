<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 		<center>Login Page</center>
         <form align="center" name="f1" method="post" action="validate.jsp">
             User Name:<input type="text" name="username" value=""><br><br>
             Password:<input type="password" name="password" value=""><br><br>
             <input type="submit" name="sub" value="Login">
         </form>
         <a href="employeeinfo.jsp">View Employee Details</a>
         <a href="registrationpage.html">New User</a>
</body>
</html>