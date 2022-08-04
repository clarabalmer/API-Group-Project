<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Search</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/favorites">Public Favorites</a>
		<a href="/login">Login</a>
	</div>
	<h1>Movie Search</h1>
	<div class="forms">
		<form action="/search" method="POST">
			Search Movies: <input type="text" value="" name="search"/>
			<input type="submit"/>
		</form>
	</div>
</body>
</html>