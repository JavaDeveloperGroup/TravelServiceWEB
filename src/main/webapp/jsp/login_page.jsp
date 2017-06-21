<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<link href="" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<font face="monospace" color="black" size="4"> <b>
			<td><c:out value="${msg}" />
	</b>
		<form action="Controller" method="POST">
			<input type="hidden" name="command" value="log_in" /> Login:<br />
			<input type="text" name="login" value="${login}" /> <br />Password:<br />
			<input type="password" name="password" value="${password}" /> <br />
			<input type="submit" value="Log in" />
		
		<hr /> <a href="Controller?command=sign_up_page"> <font
			face="monospace" color="#66CDAA">Sign up</font>
	</a>
</body>
</html>