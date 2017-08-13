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
	rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
<title>Auto catalogue</title>
</head>
<body>
	<div>
		<div id="wrapper">
			<header>
				<div>
					<a href="${pageContext.request.contextPath}/jsp/home_page.jsp">
						<img src="${pageContext.request.contextPath}/image/logoF.png"
						width="180">
					</a>
					<c:if test="${user == null}">
						<form name="sign_in" id="sign_in"
							action="${pageContext.request.contextPath}/Controller"
							method="GET">
							<input type="hidden" value="log_in_page" name="command" />
							<button type="submit">SIGN IN</button>
						</form>

						<form name="sign_up" id="sign_up"
							action="${pageContext.request.contextPath}/Controller"
							method="GET">
							<input type="hidden" value="sign_up_page" name="command" />
							<button type="submit">SIGN UP</button>
						</form>
					</c:if>
					<c:if test="${user != null}">
						<c:if
							test="${user.getClass().getSimpleName().subSequence(0, 5) == 'Admin'}">
							<form name="sign_up"
								action="${pageContext.request.contextPath}/Controller"
								method="GET">
								<tr>
									<td>${user.getLogin()}</td>
								</tr>
								<input type="hidden" value="log_out" name="command" />
								<button name="log_out" type="submit">LOG OUT</button>
							</form>
						</c:if>

						<c:if
							test="${user.getClass().getSimpleName().subSequence(0, 8) == 'Customer'}">
							<form name="sign_up"
								action="${pageContext.request.contextPath}/Controller"
								method="GET">
								<tr>
									<a
										href="${pageContext.request.contextPath}/Controller?command=update_account_page"><td>${user.getLogin()}</td></a>
								</tr>
								<input type="hidden" value="log_out" name="command" />
								<button name="log_out" type="submit">LOG OUT</button>
							</form>
						</c:if>
					</c:if>
				</div>
			</header>
			<hr>
			<div class="menu_center">
				<nav>
					<ul class="top-menu">
						<li id="about"><a href="/home/">ABOUT US</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Controller?command=tour_catalogue_page">TOUR
								CATALOGUE</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Controller?command=hotel_catalogue_page">HOTEL
								CATALOGUE</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Controller?command=auto_catalogue_page">CAR
								CATALOGUE</a></li>
						<li><a href="mailto:info@fidelio.com">EMAIL US</a></li>
					</ul>
					<select id="lang">
						<option value="RU">RUSSIAN</option>
						<option selected value="EN">ENGLISH</option>
					</select>
				</nav>
			</div>
			<hr>
			<div>
				<aside>
					<nav>
						<div class="aside-menu">
							<div class="head-cont">Transmission:</div>
							<input type="radio" name="transmission" value="auto" id="trans1" />
							<label for="trans1">Auto</label><br /> <input type="radio"
								name="transmission" value="manual" id="trans2" /> <label
								for="trans2">Manual</label><br />
							<hr class="div_tr">
							<hr>
							<div class="head-cont">Wheel drive:</div>
							<input type="checkbox" name="wheel_drive" value="rear"
								id="wheel1" /> <label for="wheel1">Rear</label><br /> <input
								type="checkbox" name="wheel_drive" value="front" id="wheel2" />
							<label for="wheel2">Front</label><br /> <input type="checkbox"
								name="wheel_drive" value="full" id="wheel3" /> <label
								for="wheel3">Full</label><br />
							<hr class="div_tr">
							<hr>
							<div class="head-cont">Fuel type:</div>
							<input type="checkbox" name="fuel_type" value="petrol" id="fuel1" />
							<label for="fuel1">Petrol</label><br /> <input type="checkbox"
								name="fuel_type" value="diesel" id="fuel2" /> <label
								for="fuel2">Diesel</label><br /> <input type="checkbox"
								name="fuel_type" value="gas" id="fuel3" /> <label for="fuel3">Gas</label><br />
							<input type="checkbox" name="fuel_type" value="electro"
								id="fuel4" /> <label for="fuel4">Electro</label><br />
							<hr class="div_tr">
							<hr>
							<div class="head-cont">Body type:</div>
							<input type="checkbox" name="body_type" value="sedan" id="body1" />
							<label for="body1">Sedan</label><br /> <input type="checkbox"
								name="body_type" value="coupe" id="body2" /> <label for="body2">Coupe</label><br />
							<input type="checkbox" name="body_type" value="suv" id="body3" />
							<label for="body3">SUV</label><br /> <input type="checkbox"
								name="body_type" value="hatchback" id="body4" /> <label
								for="body4">Hatchback</label><br />
							<hr class="div_tr">
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
						<input type="hidden" name="command" value="auto_make_order">
						<div>
							<table>
								<tr>
									<th id="ckeck">
									<th id="photo">PHOTO</th>
									<th class="col1">MODEL</th>
									<th class="col2">CHARACTERISTIC</th>
									<th class="col4">SALON</th>
									<th class="col5">PRICE</th>
								</tr>
								<c:forEach items="${list_rentAuto}" var="i">
									<tr>
										<td><input type="radio" name="id"
											value="${i.getRentAutoId()}" /></td>
										<td><img src="${i.getImage()}"></td>
										<td>${i.getAuto().toStringModel()}</td>
										<td>${i.getAuto().toStringCharacteristic()}</td>
										<td>${i.getSalon().toStringAddress()}</td>
										<td>${i.getPrice()}</td>
									</tr>
								</c:forEach>
							</table>
							<div style="text-align: center">
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