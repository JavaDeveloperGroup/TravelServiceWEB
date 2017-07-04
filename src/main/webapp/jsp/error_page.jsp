<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/image/fidelio_icon.png" rel="shortcut icon" type="image/png">
	<title>Error</title>
</head>
<style>
.center {
	text-align: center;
}
</style>
<body>
	<c:out value="${error_msg}" />
	<br>
	<div class="headline">
		<font face="monospace" color="black" size="6"> <b>ERROR</b>
		</font> <br>
	</div>
	<div class="headline">
		<a href="${pageContext.request.contextPath}/index.jsp"> 
			<font face="monospace" color=green size="6">
				HOME PAGE
			</font>
		</a>
	</div>
</body>
</html>