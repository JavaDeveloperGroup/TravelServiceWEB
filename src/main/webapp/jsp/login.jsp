<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<link href="catalog.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<form action="MainServlet" method="POST">
		<input type="hidden" name="command" value="log_in" /> Login:<br /> <input
			type="text" name="login" value="user1" /> <br />Password:<br /> <input
			type="password" name="password" value="user1" /> <br /> <input
			type="submit" value="Log in" />
	</form>
	<a href="MainServlet?command=log_in">Login</a>
	<hr />
</body>
</html>