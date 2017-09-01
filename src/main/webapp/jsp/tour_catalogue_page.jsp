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
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link
	href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png"
	rel="shortcut icon" type="image/png">
<title>Tour page</title>
</head>
<body>
	<div>
		<div id="wrapper">
		
			<%@include file="../jspf/header_default.jspf" %>
			
			<hr>
			
			<div class="menu_center">
				<%@include file="../jspf/menu.jspf" %>
			</div>
			
			<hr>
			
			<div>
				<aside>
					<nav>
						<div class="aside-menu">
							<div class="head-cont">Travel type:</div>
							<input type="checkbox" name="travel_type" value="rest"
								id="travel1" /><label for="travel1">Rest</label><br /> <input
								type="checkbox" name="travel_type" value="trip" id="travel2" /><label
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
								<input type="date" name="calendar_start" id="start1">
							</div>
							<div>
								<label for="start2">Till</label>
							</div>
							<input type="date" name="calendar_end" id="start2">
							<hr>
							<div class="head-cont">Price:</div>
							<label for="minCost">From:</label> <input class="inp_price"
								type="text" id="minCost" name="price_min" value="0" /> <label
								for="maxCost">Till: </label> <input class="inp_price"
								type="text" id="maxCost" name="price_max" value="500" />
							<hr class="div_tr">
							<div id="slider" style=""></div>
						</div>
					</nav>
				</aside>
				<div>
					<form action="${pageContext.request.contextPath}/Controller"
						method="GET">
						<input type="hidden" name="command" value="tour_make_order">
						<div>
							<table>
								<tr>
									<th id="check">
									<th id="photo">PHOTO</th>
									<th id="col1">TOUR</th>
									<th id="col6">TYPE</th>
									<th id="col2">DESCRIPTION</th>
									<th id="col3">DATES</th>
									<th id="col4">FREE PLACES</th>
									<th id="col5">PRICE</th>
								</tr>
								<c:forEach items="${list_apartment}" var="i">
									<tr>
										<td><input type="radio" name="id"
											value="${i.getTourOfferId()}" /></td>
										<td><img src="${i.getImage()}"></td>
										<td>${i.getTour().toStringTour()}</td>
										<td>${i.getTour().getType()}</td>
										<td>${i.getTour().getDescription()}</td>
										<td>${i.toStringDates()}</td>
										<td>${i.getPessengersPerOrder()}</td>
										<td>${i.getPrice()}</td>
									</tr>
								</c:forEach>
							</table>
							<div style="text-align: center;">
								<input value="ORDER" type="submit">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/slider.js"
		charset="utf-8"></script>
</body>
</html>