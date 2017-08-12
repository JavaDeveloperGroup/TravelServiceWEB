<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="src.main.webapp.properties.data_en.properties" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/css/signup.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet" type="text/css" />
	<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
	<title>Sign up</title>
</head>
<body>
	<div id="wrapper">
		<header>
			<a href="${pageContext.request.contextPath}/jsp/home_page.jsp"><img src="${pageContext.request.contextPath}/image/logoF.png" width="180"></a>
			<form name="sign_in" action="${pageContext.request.contextPath}/Controller" method="GET">
				<input type="hidden" value="log_out" name="command" />
				<tr>
					<td>${user.getLogin()}</td>
				</tr>
				<button type="submit">LOG OUT</button>
			</form>
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
					<option selected value="EN"€>ENGLISH</option>
				</select>
			</nav>
		</div>
		<hr>
		<div id="heading">
			<h2>Please, fill in the form new data!</h2>
		</div>
		<div id="heading">
			<font face="monospace" color="black" size="4"> <b>
					<td><c:out value="${msg}" /></td>
				</b>
			</font>
		</div>
		<div class='reg-form'>
			<form action="${pageContext.request.contextPath}/Controller" method="POST">
				<input type="hidden" name="command" value="update_account" />

				<div class='form-row'>
					<label for="old_password"> <span>Old password</span> <input
						type="password" <%--value="user1Q@q"--%> name='old_password'
						id="old_password" required>
						<ul class="input-requirements">
							<li>At least 8 characters long (and less than 20 characters)</li>
							<li>Contains at least 1 number</li>
							<li>Contains at least 1 lowercase letter</li>
							<li>Contains at least 1 uppercase letter</li>
							<li>Contains a special character (e.g. @ !)</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="new_password"> <span>New password</span> <input
						type="password" <%--value="user1Q@q"--%> name='new_password'
						id="new_password" required>
						<ul class="input-requirements">
							<li>At least 8 characters long (and less than 20 characters)</li>
							<li>Contains at least 1 number</li>
							<li>Contains at least 1 lowercase letter</li>
							<li>Contains at least 1 uppercase letter</li>
							<li>Contains a special character (e.g. @ !)</li>
						</ul>
					</label>
				</div>
				
				<div class='form-row'>
					<label for="password_repeat"> <span>Repeat password
					</span> <input type="password" <%--value="user1Q@q"--%> name='password_repeat'
						id="password_repeat" required>
					</label>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>

				<div class='form-row' id="selectgender">
					<label><div style="float: left;"><span>Gender</span></div>
						<div> 
							<font size="3">
								<select id="gender" name='gender' style="width: 492px;">				
									<c:if test="${user.getGender() != 'Male'}">
										<option value="Female">${user.getGender()}</option>
										<option value="Male">Male</option>
									</c:if>
									<c:if test="${user.getGender() != 'Female'}">
										<option value="Male">${user.getGender()}</option>
										<option value="Female">Female</option>
									</c:if>
								</select>
							</font>
						</div>
					</label>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class="form-row">
					<label>
						<span>Birthday</span> 
						<font size="3">
							<input value="${user.getBirthday()}" type="date" placeholder="Birth date"
							title="Format: YYYY-MM-DD" name="birthday" id="birthday"/>
						</font>
					</label>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Email </label> <input type='email' id="email" value="${user.getEmail()}"
						name='email' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Phone </label> <input id="phone" 
						name='phone_number' value="${user.getPhoneNumber()}" required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>

				<div class='form-row'>
					<label>
						<div style="float: left;"><span>Driver licence</span></div>
						<div>
							<font size="3"> 
								<select id="driver_licence"	name='driver_licence' style="width: 492px;">
									<c:if test="${user.getDriverLicence() != 'No'}">
										<option value="Yes">${user.getDriverLicence()}</option>
										<option value="No">No</option>
									</c:if>
									<c:if test="${user.getDriverLicence() != 'Yes'}">
										<option value="No">${user.getDriverLicence()}</option>
										<option value="Yes">Yes</option>
									</c:if>
								</select>
							</font>
						</div> 
					</label>
				</div>

				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class="form-row">
					<input type="submit" id="go" value='Go' />
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
			</form>
		</div>
		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/scriptUpdate.js" charset="utf-8"></script>

</body>
</html>