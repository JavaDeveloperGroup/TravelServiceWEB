<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet" type="text/css" />
	<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
	<title>Log in</title>
</head>
<body>
	<div id="wrapper">
		<header>
			<a href="${pageContext.request.contextPath}/jsp/home_page.jsp">
				<img src="${pageContext.request.contextPath}/image/logoF.png" width="180">
			</a>
			<form name="back" action="${pageContext.request.contextPath}/Controller" method="GET">
				<input type="hidden" name="command" value="back_page" />
				<button type="submit">BACK</button>
			</form>
			<form name="sign_up" action="${pageContext.request.contextPath}/Controller" method="GET">
				<input type="hidden" value="sign_up_page" name="command" />
				<button type="submit">SIGN UP</button>
			</form>
		</header>
		<jsp:include page="/jspf/menu.jspf" />
		<hr>
		<div id="heading">
			<h2>Please, fill in the form to log in!</h2>
		</div>
		<font face="monospace" color="black" size="4"> 
			<b>
				<td>
					<h2><c:out value="${msg}" /></h2>
				</td>
			</b>
		</font>
		<div id="login_form">
			<form action="${pageContext.request.contextPath}/Controller" method="POST">
				<input type="hidden" name="command" value="log_in" />
				<p>Login:</p>
				<input type="text" name="login" value="user1" placeholder="LOGIN" />
				<p>Password:</p>
				<input type="password" name="password" value="user1Q@q" placeholder="PASSWORD"/> 
				<br> 
				<input type="submit" value="Log in" id="subbut"/>
			</form>
		</div>
		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>
</body>
</html>