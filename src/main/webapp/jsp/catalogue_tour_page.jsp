<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="${pageContext.request.contextPath}/css/catalogue.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/footer.css"
	rel="stylesheet" type="text/css" />
<title>Tour catalogue</title>
</head>
<body>
	<div id="wrapper">
		<header>
			<a href="/"><img
				src="${pageContext.request.contextPath}/image/logoF.png" width="180"></a>
			<form name="sign_in" action="#" method="get">
				<button type="submit">SIGN IN</button>
			</form>
			<form name="sign_up" action="#" method="get">
				<button type="submit">SIGN UP</button>
			</form>
		</header>
		<jsp:include page="/jspf/menu.jspf" />
		<hr>
		<aside>
			<nav>
				<div class="aside-menu">
					<div class="head-cont">Travel type:</div>
					<input type="checkbox" name="travel_type" value="rest" id="travel1" /><label
						for="travel1">Rest</label><br /> <input type="checkbox"
						name="travel_type" value="trip" id="travel2" /><label
						for="travel2">Trip</label> <br /> <input type="checkbox"
						name="travel_type" value="shop" id="travel3" /><label
						for="travel3">Shop</label>
					<hr>
					<div class="head-cont">Hot tours only:</div>
					<input type="radio" name="hot" value="yes" id="hot1" /><label
						for="hot1">Yes</label><br /> <input type="radio" name="hot"
						value="no" id="hot2" /><label for="hot2">No</label><br />
					<hr>
					<div class="head-cont">Start date:</div>
					<label for="start1">From</label>
					<div>
						<input type="date" name="calendar" id="start1">
					</div>
					<label for="start2">Till</label> <input type="date" name="calendar"
						id="start2">
					<hr>
					<div class="head-cont">Price:</div>
					<input type="range" min="0" max="180" step="10" multiple>
				</div>
			</nav>
		</aside>

		<table>
			<tr>
				<th id="photo">PHOTO</th>
				<th>HOTEL</th>
				<th>ADDRESS</th>
				<th>STAR RATE</th>
				<th>NUMBER OF PERSONS</th>
				<th>PRICE</th>
			</tr>
			<tr>
				<td><img
					src="http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg"></td>
				<td>gyyy</td>
				<td>fttt</td>
				<td>tfff</td>
				<td>fttt</td>
				<td>cfff</td>
			</tr>
		</table>

		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>
</body>
</html>