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

<title>Auto catalogue</title>
</head>
<body>
<div>
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
					<div class="head-cont">Transmission:</div>
					<input type="radio" name="transmission" value="auto" id="trans1" /><label
						for="trans1">Auto</label><br /> <input type="radio"
						name="transmission" value="manual" id="trans2" /><label
						for="trans2">Manual</label><br />
					<hr class="div_tr">
					<hr>
					<div class="head-cont">Wheel drive:</div>
					<input type="checkbox" name="wheel_drive" value="rear" id="wheel1" /><label
						for="wheel1">Rear</label><br /> <input type="checkbox"
						name="wheel_drive" value="front" id="wheel2" /><label
						for="wheel2">Front</label><br /> <input type="checkbox"
						name="wheel_drive" value="full" id="wheel3" /><label for="wheel3">Full</label><br />
					<hr class="div_tr">
					<hr>
					<div class="head-cont">Fuel type:</div>
					<input type="checkbox" name="fuel_type" value="petrol" id="fuel1" /><label
						for="fuel1">Petrol</label><br /> <input type="checkbox"
						name="fuel_type" value="diesel" id="fuel2" /><label for="fuel2">Diesel</label><br />
					<input type="checkbox" name="fuel_type" value="gas" id="fuel3" /><label
						for="fuel3">Gas</label><br /> <input type="checkbox"
						name="fuel_type" value="electro" id="fuel4" /><label for="fuel4">Electro</label><br />
					<hr class="div_tr">
					<hr>
					<div class="head-cont">Body type:</div>
					<input type="checkbox" name="body_type" value="sedan" id="body1" /><label
						for="body1">Sedan</label><br /> <input type="checkbox"
						name="body_type" value="coupe" id="body2" /><label for="body2">Coupe</label><br />
					<input type="checkbox" name="body_type" value="suv" id="body3" /><label
						for="body3">SUV</label><br /> <input type="checkbox"
						name="body_type" value="hatchback" id="body4" /><label
						for="body4">Hatchback</label><br />
					<hr class="div_tr">
					<hr>
					<div class="head-cont">Price:</div>
					<label for="minCost">From: </label> <input type="text" id="minCost"
						value="0" /> <label for="maxCost">Till: </label> <input
						type="text" id="maxCost" value="500" />
					<hr class="div_tr">
					<div id="slider" style=""></div>

				</div>
			</nav>
		</aside>

		<table>
			<tr>
				<th id="photo">PHOTO</th>
				<th class="col1">HOTEL</th>
				<th class="col2">ADDRESS</th>
				<th class="col3">STAR RATE</th>
				<th class="col4">NUMBER OF PERSONS</th>
				<th class="col5">PRICE</th>
			</tr>
			<tr>
				<td><img
					src="http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg"></td>
				<td>gyyyy</td>
				<td>ftttt</td>
				<td>tffff</td>
				<td>fttt</td>
				<td>cfff</td>
			</tr>
			
		</table>
	</div>

		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/slider.js"
		charset="utf-8"></script>

</body>
</html>