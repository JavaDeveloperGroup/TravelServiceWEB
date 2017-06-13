<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
<link href="css/catalog_page.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="width: 100%; height: 1px; clear: both;"></div>
	<div>
		<c:if test="${user==null}">
			<div style="float: right; margin-left: 15px;">
				<form action="MainServlet" method="POST">
					<input type="hidden" value="log_in" name="command" />
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
		</c:if>
	</div>
	<div >
		<c:if test="${user!=null}">
			<div style="float: right;">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="log_out" name="command" />
					<div style="float: left; margin-left: 15px;">
						<tr>
							<td>${user.getLogin()}</td>
						</tr>
					</div>
					<div style="float: left; margin-left: 15px;">
						<input value="LOG OUT" type="submit">
					</div>
				</form>
			</div>
		</c:if>
	</div>
	<div style="width: 100%; height: 1px; clear: both;"></div>
	<div>
		<div class="row">
			<div>
				<p align="center">
					<font face="monospace" color="white" size="18"> <b>Travel</b>
					</font>
				</p>
			</div>
			<div
				style="margin-left: 30px; height: 70px; margin-bottom: 6px; background-image: url(image/apartment.jpg); border-radius: 8px; margin-right: 30px;">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="catalog_hotel" name="command" />
					<button class="btn2" value="CATALOG" type="submit">HOTEL</button>
				</form>
			</div>
			<div
				style="margin-left: 30px; height: 70px; margin-bottom: 6px; background-image: url(image/auto.jpg); border-radius: 8px; margin-right: 30px; margin-top: 10px;">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="catalog_auto" name="command" />
					<button class="btn2" value="CATALOG" type="submit">RENTAL
						AUTO</button>
				</form>
			</div>
			<div
				style="margin-left: 30px; height: 70px; margin-bottom: 20px; background-image: url(image/tour.jpg); border-radius: 8px; margin-right: 30px; margin-top: 10px;">
				<form action="MainServlet" method="GET">
					<input type="hidden" value="catalog_tour" name="command" />
					<button class="btn2" value="CATALOG" type="submit">TRAVEL
						TOUR</button>
				</form>
			</div>
		</div>
	</div>
	<div
		style="font-family: 'Raleway', sans-serif; float: left; margin-left: 0px; width: 250px; background: white">
		<form action="MainServlet" method="GET">
			<input type="hidden" value="sort" name="command" />
			<div style="margin-bottom: 20px; margin-top: 30px;">
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
			</div>
			<div>
				<input value="sort" type="submit">
			</div>
		</form>
	</div>
	<div style="float: left; background: #f2f2f2">
		<form action="MainServlet" method="GET">
			<input type="hidden" name="command" value="make_order">
			<div style="margin-bottom: 30px;">
				<table border="1">
					<c:forEach items="${list_apartment}" var="i">
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
				<input class="btn2" value="ORDER" type="submit">
			</div>
		</form>
	</div>
</body>
</html>