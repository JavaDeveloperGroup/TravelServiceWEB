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
		<link href="${pageContext.request.contextPath}/css/auto/example_auto.css"
			rel="stylesheet" type="text/css" />
		<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png"
			rel="shortcut icon" type="image/png">
			
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
		<title>Auto catalogue</title>
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
	
				<div class="auto_wrapper"
					style="background: transparent url('http://res.cloudinary.com/javadevgroup/image/upload/v1502052645/auto/bg_homepage_default.jpg') no-repeat center;">
					<div class="resul_form">
						<form name="carform" action="${pageContext.request.contextPath}/Controller" method="post">
						
							<li class="block_title"><h2>Find Your Car Hire Here</h2></li>
	
							<li>
								<div id="pu_menu-based">
									<select id="pucity">
										<option value=""> Select Pick-up City </option>
										<c:forEach items="${CITY_LIST}" var="i">
											<option value="${i.getName()}">${i.getName()}</option>
										</c:forEach>
									</select> 
									<select id="puloclist" disabled1="1disabled">
										<option value=""> Select Pick-up Location </option>
										<c:forEach items="${SALON_LIST}" var="j">
											<option value="${j.getAddress()}">${j.getAddress()}</option>
										</c:forEach>
									</select>
								</div> 
								
								<label for="book_doPrompt" class="ShowLoc"> 
									<input id="book_doPrompt" name="book_doPrompt" type="checkbox">Drop	off at a Different Location?
								</label>
	
								<div id="doLoc">
									<div id="do_menu-based">
	
										<select id="docity">
											<option value=""> Select Drop-off City </option>
										</select> 
										
										<select id="doloclist">
											<option value=""> Select Drop-off Location </option>
										</select>
	
									</div>
								</div>
							</li>
	
							<li>
								<label for="pu_date" class="book_label">PICK-UP </label>
								<div class="book_stepContainter">
									<div class="cal_wrap">
										<input name="puCal" id="pu_date" class="book_calInput hasDatepicker" readonly="readonly" value="" type="text"> 
										<input name="pu_datePost" id="pu_datePost" class="book_calInput" value="08-09-2017" type="hidden">
									</div>
	
									<select id="ga_pickup_time" class="sfTimesDD" name="selDDpu_time">
										<option value="00:00">00:00</option>
										<option value="00:30">00:30</option>
									</select>
								</div>
							</li>
	
							<li class="do_dateLi">
								<label for="do_date" class="book_label">DROP-OFF </label>
								<div class="book_stepContainter">
									<div class="cal_wrap">
										<input name="doCal" id="do_date" class="book_calInput hasDatepicker" readonly="readonly" value="" type="text" /> 
										<input name="do_datePost" id="do_datePost" class="book_calInput" value="08-12-2017"	type="hidden" />
									</div>
	
									<select id="ga_dropoff_time" class="sfTimesDD" name="selDDdo_time">
										<option value="00:00">00:00</option>
										<option value="00:30">00:30</option>
									</select>
								</div>
							</li>
							<button type="submit" class="search book_btn align_right" name="submitForm" id="menuSubmitButton">
								<span> Get Your Quote </span>
							</button>
						</form>
					</div>
				</div>
			</div>
	
			<div id="foot">
				<jsp:include page="/jspf/footer.jspf" />
			</div>
			
		</div>
	
		<script src="${pageContext.request.contextPath}/js/slider.js" charset="utf-8"></script>
	
	</body>
</html>