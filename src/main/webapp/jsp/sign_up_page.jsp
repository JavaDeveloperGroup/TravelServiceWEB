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
	<title>Sign up</title>
</head>
<body>
	<div id="wrapper">
	
		<header>
			<a href="${pageContext.request.contextPath}/jsp/home_page.jsp"><img src="${pageContext.request.contextPath}/image/logoF.png" width="180"></a>
			<form name="back" action="${pageContext.request.contextPath}/Controller" method="GET">
				<input type="hidden" name="command" value="back_page" />
				<button type="submit"><!--<fmt:message key="back" />-->BACK</button>
			</form>
			<form name="sign_in"
				action="${pageContext.request.contextPath}/Controller" method="GET">
				<input type="hidden" value="log_in_page" name="command" />
				<button type="submit">SIGN IN</button>
			</form>
		</header>
		
		<jsp:include page="/jspf/menu.jspf" />
		
		<hr>
		<div id="heading">
			<h2><!--<fmt:message key="sign_up_invitation" />--> Please, fill in the form to sign up!</h2>
		</div>
		<font face="monospace" color="black" size="4"> 
			<b>
				<td>
					<c:out value="${msg}" />
				</td>
			</b>
		</font>
		
		<div class='reg-form'>
			<form action="${pageContext.request.contextPath}/Controller" method="POST">
				<input type="hidden" name="command" value="sign_up" />

				<div class='form-row'>
					<label for="name"> <span><!--<fmt:message key="first_name" />--> Name </span> <input
						type='text' value="Yauheni" id="name" name='name' required>
						<ul class="input-requirements">
							<li>Should be at least 2 characters long.</li>
							<li>Should only contain letters.</li>
							<li>Should start with an uppercase letter.</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="surname"> <span><!--<fmt:message key="second_name" />--> Surname </span> <input
						type='text' value="Papovich" id="surname" name='surname' required>
						<ul class="input-requirements">
							<li>Should be at least 2 characters long.</li>
							<li>Should only contain letters.</li>
							<li>Should start with an uppercase letter.</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="username"> <span><!--<fmt:message key="login" />--> Login </span> <input
						type='text' pattern="[a-zA-Z0-9]{3-8}" value="user" name='login' id="username"
						required>
						<ul class="input-requirements">
							<li>At least 3 characters long</li>
							<li>Must only contain letters and numbers (no special
								characters)</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="password"> <span>Password</span> <input
						type="password" value="user1Q@q" name='password'
						id="password" required>
						<ul class="input-requirements">
							<li>At least 8 characters long (and less than 100 characters)</li>
							<li>Contains at least 1 number</li>
							<li>Contains at least 1 lowercase letter</li>
							<li>Contains at least 1 uppercase letter</li>
							<li>Contains a special character (e.g. @ !)</li>
						</ul>
					</label>
				</div>

				<div class='form-row'>
					<label for="password_repeat"> <span> Repeat Password
					</span> <input placeholder="Repeat Password" 
						type="password" value="user1Q@q" name='repeat_password'
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
							<input value="2017-06-30" type="date" placeholder="Birth date"
							title="Format: YYYY-MM-DD" name="birthday" />
						</font>
					</label>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Passport </label> <input pattern="[A-Z]{2}+([0-9]{7})"
						value="AA2222222" name='passport' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Email </label> <input type='email' value="po@mail.ru"
						name='email' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Phone </label> <input placeholder="+375(_ _)_ _ _-_ _-_ _"
						pattern="(29|44|33|25)+([0-9]{7})" value="333333333"
						name='phone_number' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class='form-row'>
					<label>Driver licence </label> <input pattern="[a-zA-Z]{2,3}"
						value="No" name='driver_licence' required>
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
				<div class="form-row">
					<input type="submit" value='Go' />
				</div>
				
				<div style="width: 100%; height: 1px; clear: both;"></div>
				
			</form>
		</div>
		<div id="foot">
			<jsp:include page="/jspf/footer.jspf" />
		</div>
	</div>

	<script src="http://localhost:8080/travelservice/js/script.js" charset="utf-8"></script>

</body>
</html>