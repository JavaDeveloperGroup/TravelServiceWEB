<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="motionpack.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="NewFile.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="width: 100%; height: 1px; clear: both;"></div>
	<div>
		<div style="float: left; margin-left: 15px;">
			<form action="MainServlet" method="POST">
				<input type="hidden" value="login" name="action" />
				<div style="float: left; margin-left: 15px;">
					<input value="user" type="text" name="login" required />
				</div>
				<div style="float: left; margin-left: 15px;">
					<input value="user" type="password" name="password" required />
				</div>
				<div style="float: left; margin-left: 15px;">
					<input value="Log in" type="submit" />
				</div>
			</form>
		</div>
	</div>
	<div>
		<div style="float: left; margin-left: 60px;">
			<form action="MainServlet" method="GET">
				<input type="hidden" value="log_out" name="action" />
				<div style="float: left; margin-left: 15px;">
					<c:out value="${fname}" />
				</div>
				<div style="float: left; margin-left: 15px;">
					<input value="LOG OUT" type="submit">
				</div>
			</form>
		</div>
	</div>
	<div style="width: 100%; height: 1px; clear: both;"></div>
	<div>
		<div class="row">
			<div style="background-image: url(image/mate.png);">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="catalog" name="action" />
					<button class="btn sm secondary" value="CATALOG" type="submit">Secondary</button>
				</form>
			</div>
			<div style="background-image: url(image/travel.jpg);">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="catalog" name="action" />
					<button class="btn sm cta" value="CATALOG" type="submit">Call</button>
				</form>
			</div>
			<div style="background-image: url(image/mate.png);">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="catalog" name="action" />
					<button class="btn sm ghost" value="CATALOG" type="submit">Ghost</button>
				</form>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="header">
			<h1>Travel</h1>
			<h3>lalalalala</h3>
		</div>
	</div>
	<div
		style="font-family: 'Raleway', sans-serif; float: left; margin-left: 0px; width: 250px; background: white">
		<form action="MainServlet" method="GET">
			<input type="hidden" value="log_out" name="action" />
			<div style="margin-bottom: 20px;">
				<select name="hero">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>
			<div style="margin-bottom: 20px;">
				<div>
					<td><input type="checkbox" name="id" value="3" />3 stars</td>
				</div>
				<div>
					<td><input type="checkbox" name="id" value="4" />4 stars</td>
				</div>
				<div>
					<td><input type="checkbox" name="id" value="5" />5 stars</td>
				</div>
				<div>
					<td><input type="checkbox" name="id" value="6" />6 stars</td>
				</div>
				<div>
					<td><input type="checkbox" name="id" value="7" />7 stars</td>
				</div>
			</div>
			<div>
				<input value="sort" type="submit">
			</div>
		</form>
	</div>
	<div>
		<form action="MainServlet" method="GET">
			<input type="hidden" name="action" value="make_order">
			<div>
				<table border="1">
					<c:forEach items="${list_eq}" var="i">
						<tr>
							<td style="width: 20px;"><input type="radio" name="id"
								value="${i.gettId()}" /></td>
							<td style="width: 140px;"><img border="6px solid #00a8e1"
								src="image/seba.png" height="60"></td>
							<td style="width:;">${i.getName()}</td>
							<td style="width: 50px;"><div>30.0$</div></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>
			<div class="center">
				<input class="btn2" type="submit">
			</div>
		</form>
	</div>
</body>
</html>