<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet" type="text/css" />
	<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
	<title>Home page</title>
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

			<div id="fadein">
				<div>
					<img
						src="http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg">
					<p>
						Perfect vacations in luxurious hotel apartments! <br> To
						explore all options available, please, check our hotel catalogue.
					</p>
				</div>
				<div>
					<img
						src="http://res.cloudinary.com/javadevgroup/image/upload/v1497429719/tourpics/krasnybor_ywoeag.jpg">
					<p>
						Magnificent views and perfect holidays! <br> To explore all
						options available, please, check our tour catalogue.
					</p>
				</div>
				<div>
					<img
						src="http://res.cloudinary.com/javadevgroup/image/upload/v1497805529/auto/2015_mercedes-benz_c-class_sedan_c300_xbc5ol.jpg">
					<p>
						Fantastically powerful and stylish cars! <br> To explore all
						options available, please, check our car catalogue.
					</p>
				</div>
			</div>
		</div>
		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>
</body>
</html>