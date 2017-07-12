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
		<jsp:include page="/jspf/menu.jspf" />
		<hr>
		<div id="heading">
			<h2><!--<fmt:message key="sign_up_invitation" />--> Please, fill in the form new data!</h2>
		</div>
		<div id="heading">
			<font face="monospace" color="black" size="4"> <b>
					<td><c:out value="${msg}" /></td>
				</b>
			</font>
		</div>
		<div class='reg-form'>
			<form action="${pageContext.request.contextPath}/Controller" method="POST">
				<input type="hidden" name="command" value="sign_up" />

				<div class='form-row'>
					<label for="name"> <span><!--<fmt:message key="first_name" />--> Name </span> <input
						type='text' <%--value="Yauheni"--%> id="name" name='name' required>
						<ul class="input-requirements">
							<li>Should be at least 1 character long.</li>
							<li>Should only contain letters.</li>
							<li>Should start with an uppercase letter.</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="surname"> <span><!--<fmt:message key="second_name" />--> Surname </span> <input
						type='text' <%--value="Papovich"--%> id="surname" name='surname' required>
						<ul class="input-requirements">
							<li>Should be at least 1 characters long.</li>
							<li>Should only contain letters.</li>
							<li>Should start with an uppercase letter.</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="username"> <span><!--<fmt:message key="login" />--> Login </span> <input
						type='text' <%--value="user"--%> name='login' id="login"
						required>
						<ul class="input-requirements">
							<li>At least 3-20 characters long</li>
							<li>Must only contain letters and numbers (no special
								characters)</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="password"> <span>Password</span> <input
						type="password" <%--value="user1Q@q"--%> name='password'
						id="password" required>
						<ul class="input-requirements">
							<li>At least 8 characters long (and less than 100 characters)</li>
							<li>Contains at least 1 number</li>
							<li>Contains at least 1 lowercase letter</li>
							<li>Contains at least 1 uppercase letter</li>
							<li>Contains a special character (!, @, #, $, %, ^, &, *)</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="password_repeat"> <span> Repeat Password
					</span> <input type="password" <%--value="user1Q@q"--%> name='repeat_password'
						id="password_repeat" required>
					</label>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>

				<div class='form-row' id="selectgender">
					<label><div style="float: left;"><span>Gender</span></div>
						<div> 
							<font size="3">
								<select id="gender" name='gender' style="width: 492px;">				
									<!-- <option selected disabled value="male">Choose here</option>-->
									<option value="male">Male</option>
									<option value="female">Female</option>
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
							<input <%--value="1999-06-30"--%> type="date" placeholder="Birth date"
							title="Format: YYYY-MM-DD" name="birthday" id="birthday"/>
						</font>
					</label>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Passport </label> <input 
						<%--value="AA2222222"--%> name='passport' id="passport" required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Email </label> <input type='email' id="email" <%--value="po@mail.ru"--%>
						name='email' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Phone </label> <input <%--value="+375293333333"--%> id="phone" 
						name='phone_number' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>

				<div class='form-row'>
					<label>
						<div style="float: left;"><span>Driver licence</span></div>
						<div>
							<font size="3"> 
								<select id="driver_licence"	name='driver_licence' style="width: 492px;">
									<c:if test="${user.getDriverLicence() != 'No'}">
										<option value="YES">${user.getDriverLicence()}</option>
										<option value="NO">No</option>
									</c:if>
									<c:if test="${user.getDriverLicence() != 'Yes'}">
										<option value="NO">${user.getDriverLicence()}</option>
										<option value="YES">Yes</option>
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

	<script src="${pageContext.request.contextPath}/js/script.js" charset="utf-8"></script>

</body>
</html>