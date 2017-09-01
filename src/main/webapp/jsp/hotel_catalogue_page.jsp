<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<link href="${pageContext.request.contextPath}/css/catalogue.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
<title>Hotel catalogue</title>
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
							<div class="head-cont">Star rate:</div>
							<input type="checkbox" name="id_stars" value="3" />3 &#9733;
							(Cat. B)
							<br /> <input type="checkbox" name="id_stars" value="4" />4
							&#9733; (Cat. A)
							 <br /> <input type="checkbox" name="id_stars" value="5" />5
							&#9733; (Cat. De Luxe)
							<hr>
							<div class="head-cont">Number of persons:</div>
							<input type="radio" name="id_num_persons" value="1" />1 (single)
							 <br /> <input type="radio" name="id_num_persons" value="2" />2
							(double)
							 <br /> <input type="radio" name="id_num_persons" value="3" />2
							+ 1 additional bed
							 <br /> <input type="radio" name="id_num_persons" value="4" />2
							+ 2 additional beds
							
							<hr>
							<div class="head-cont">Price:</div>
							From:<input class="inp_price"
								type="text" id="minCost" name="price_min" value="0" />Till:<input class="inp_price"
								type="text" id="maxCost" name="price_max" value="500" />
							<hr class="div_tr">
							<div id="slider" style=""></div>
						</div>
					</nav>
				</aside>
				<div class="table">
					<form action="${pageContext.request.contextPath}/Controller"
						method="GET">
						<input type="hidden" name="command" value="hotel_make_order">
						<div>
							<table>
								<tr>
									<th id="ckeck">
									<th id="photo"></th>
									<th class="col1"></th>
									<th class="col2"></th>
									<th class="col3"></th>
									<th class="col4"></th>
									<th class="col5"></th>
								</tr>
							
								<c:forEach items="${APARTMENT_LIST}" var="a">
								
									<tr>
										<td><input type="radio" name="id" value="${a.getApartmentId()}" /></td>
										<td><img src="${a.getImage()}"></td>
										<td>${hotel_map.get(a.getHotelId()).getTitle()} <br> 
											${city_map.get(hotel_map.get(a.getHotelId()).getCityId()).getName()} <br> 
											${hotel_map.get(a.getHotelId()).getAddress()}</td>
										<td>${room_map.get(a.getRoomId()).toStringTV()} <br> 
											${room_map.get(a.getRoomId()).toStringBalcony()} <br> 
											${room_map.get(a.getRoomId()).toStringConditioner()}</td>
										<td>${hotel_map.get(a.getHotelId()).getStars()} &#10026</td>
										<td>${a.getRoomCapacity()} &#9786</td>
										<td>${a.getPrice()}</td>
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