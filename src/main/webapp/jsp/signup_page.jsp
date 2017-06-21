<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<link href="<c:url value="css/signup_page.css"/>" rel="stylesheet" type="text/css" />
</head>
<body class="center" topmargin="0">
	<div class="name">
		<div class="name2">
			<p align="center">
				<font face="monospace" color="black" size="9"> <b>Travel
						Service</b>
				</font>
			</p>
		</div>
	</div>
	<font face="monospace" color="black" size="4"> <b> ${msg} </b>
	</font>
	<div class='reg-form'>
		<div class='reg-form'>
			<form action="Controller" method="POST">
				<input type="hidden" name="command" value="sign_up" />
				<p class="center">
					<font face="monospace" color="black" size="6"> <b>SIGNUP</b>
					</font>
				</p>

				<div class='form-row'>
					<label>First Name </label> <input type='text' value="Yauheni"
						name='name' required>
				</div>

				<div class='form-row'>
					<label>Second Name </label> <input type='text' value="Papovich"
						name='surname' required>
				</div>

				<div class='form-row'>
					<label>Login </label> <input placeholder="4 - 8 simbols"
						type='text' pattern="[a-zA-Z0-9]{4,8}" value="user" name='login'
						required>
				</div>

				<div class='form-row'>
					<label>Password </label> <input placeholder="4 - 8 simbols"
						type="password" pattern="[a-zA-Z0-9]{4,8}" value="user"
						name='password' required>
				</div>

				<div class='form-row'>
					<label>Repeat Pass.</label> <input placeholder="Repeat Password"
						pattern="[a-zA-Z0-9]{4,8}" type="password" value="user"
						name='repeat_password' required>
				</div>

				<div class='form-row'>
					<label>Gender </label> <input placeholder="male/female" type='text'
						pattern="(|fe)male" value="male" name='gender' required>
				</div>

				<div class="form-row">
					<label>Birthday</label> <input type="date" placeholder="Birth date"
						title="Format: YYYY-MM-DD" name="birthday" required/>
				</div>

				<div class='form-row'>
					<label>Passport </label> <input pattern="[A-Z]{2}+([0-9]{7})"
						value="AA2222222" name='passport' required>
				</div>

				<div class='form-row'>
					<label>Email </label> <input type='email' value="po@mail.ru"
						name='email' required>
				</div>

				<div class='form-row'>
					<label>Phone </label> <input placeholder="+375(_ _)_ _ _-_ _-_ _"
						pattern="(29|44|33|25)+([0-9]{7})" value="333333333"
						name='phone_number' required>
				</div>

				<div class='form-row'>
					<label>Driver license </label> <input pattern="[a-zA-Z]{2,3}"
						value="No" name='driver_license' required>
				</div>

				<div class="form-row">
					<input type="submit" value='Go' />
				</div>
			</form>
		</div>
	</div>
</body>
</html>