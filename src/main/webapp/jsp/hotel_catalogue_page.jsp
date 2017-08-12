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
<title>Hotel page</title>
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
				<%@include file="menu.jsp" %>
			</div>
			
			<hr>
			<div>
				<aside>
					<nav>
						<div class="aside-menu">
							<div class="head-cont">Star rate:</div>
							<input type="checkbox" name="id_stars" value="3" />3 &#9733;
							(Cat. B)
							</td> <br /> <input type="checkbox" name="id_stars" value="4" />4
							&#9733; (Cat. A)
							</td> <br /> <input type="checkbox" name="id_stars" value="5" />5
							&#9733; (Cat. De Luxe)
							</td>
							<hr>
							<div class="head-cont">Number of persons:</div>
							<input type="radio" name="id_num_persons" value="1" />1 (single)
							</td> <br /> <input type="radio" name="id_num_persons" value="2" />2
							(double)
							</td> <br /> <input type="radio" name="id_num_persons" value="3" />2
							+ 1 additional bed
							</td> <br /> <input type="radio" name="id_num_persons" value="4" />2
							+ 2 additional beds
							</td>
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
						<input type="hidden" name="command" value="hotel_make_order">
						<div>
							<table>
								<tr>
									<th id="ckeck">
									<th id="photo">PHOTO</th>
									<th class="col1">HOTEL</th>
									<th class="col2">ADDRESS</th>
									<th class="col3">STAR RATE</th>
									<th class="col4">NUMBER OF PERSONS</th>
									<th class="col5">PRICE</th>
								</tr>
								<c:forEach items="${list_apartment}" var="i">
									<tr>
										<td><input type="radio" name="id"
											value="${i.getApartmentId()}" /></td>
										<td><img src="${i.getImage()}"></td>
										<td>${i.getHotel().getTitle()}</td>
										<td>${i.getHotel().toStringAddress()}</td>
										<td>${i.getHotel().getStars()}</td>
										<td>${i.getRoom().getCapacity()}</td>
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