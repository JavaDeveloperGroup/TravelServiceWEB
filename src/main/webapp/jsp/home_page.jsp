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
<%
	boolean isCustomer = false, isAdmin = false;
	Object userJSP = request.getSession().getAttribute("user");
	if(userJSP != null) {
		if("Customer".equals(userJSP.getClass().getSimpleName())) {
			isCustomer = true;
			request.getSession().setAttribute("isCustomer", new Boolean(isCustomer));
		}
		else if("AdminTOWP".equals(userJSP.getClass().getSimpleName())) {
			isAdmin = true;
			request.getSession().setAttribute("isAdmin", new Boolean(isAdmin));
		}
	}
%>
	<div id="wrapper">
		<header>
			<div>
				<a href="${pageContext.request.contextPath}/jsp/home_page.jsp">
					<img src="${pageContext.request.contextPath}/image/logoF.png" width="180">
				</a>
				<c:if test="${user == null}">
					<form name="sign_in" action="${pageContext.request.contextPath}/Controller" method="GET">
						<input type="hidden" value="log_in_page" name="command" />
						<button type="submit">SIGN IN</button>
					</form>

					<form name="sign_up" action="${pageContext.request.contextPath}/Controller" method="GET">
						<input type="hidden" value="sign_up_page" name="command" />
						<button type="submit">SIGN UP</button>
					</form>
				</c:if>
				<c:if test="${user != null}">
					<c:if test="${isCustomer == null}">
						<form name="sign_up" action="${pageContext.request.contextPath}/Controller" method="GET">
							<tr>
								<td>${user.getLogin()}</td>
							</tr>
							<input type="hidden" value="log_out" name="command" />
							<button name="log_out" type="submit">LOG OUT</button>
						</form>
					</c:if>	
					
					<c:if test="${isAdmin == null}">			
						<form name="sign_up" action="${pageContext.request.contextPath}/Controller" method="GET">
						<tr>
							<a href="${pageContext.request.contextPath}/Controller?command=update_account_page"><td>${user.getLogin()}</td></a>
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
		<div id="fadein">
			<div>
				<img src="http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg">
				<p>
					Perfect vacations in luxurious hotel apartments! <br> To
					explore all options available, please, check our hotel catalogue.
				</p>
			</div>
			<div>
				<img src="http://res.cloudinary.com/javadevgroup/image/upload/v1497429719/tourpics/krasnybor_ywoeag.jpg">
				<p>
					Magnificent views and perfect holidays! <br> To explore all
					options available, please, check our tour catalogue.
				</p>
			</div>
			<div>
				<img src="http://res.cloudinary.com/javadevgroup/image/upload/v1497805529/auto/2015_mercedes-benz_c-class_sedan_c300_xbc5ol.jpg">
				<p>
					Fantastically powerful and stylish cars! <br> To explore all
					options available, please, check our car catalogue.
				</p>
			</div>
		</div>
		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>

	</div>
</body>
</html>