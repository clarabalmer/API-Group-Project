<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/favorites">Public Favorites</a>
		<a href="/">Go To Home Page</a>
	</div>
	<h1>Login</h1>
	<div class=forms>
		<form action="/login" method="POST">
			Enter an existing username, or start a new one: <br>
			<input type="text" name="username"/>
			<input type="submit"/>
		</form>
	</div>

</body>
</html>