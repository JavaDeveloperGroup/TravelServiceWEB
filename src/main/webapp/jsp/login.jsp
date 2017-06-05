<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="MainServlet" method="POST">
		<input type="hidden" name="command" value="log_in"/> Login:<br/> 
		<input type="text" name="login" value=""/> <br/>Password:<br/> 
		<input type="password" name="password" value=""/> <br/>
		<input type="submit" value="Log in"/>
	</form>
	<a href="MainServlet?command=log_in">Login</a>
	<hr/>
</body>
</html>