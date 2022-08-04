<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${username}'s Watchlist Homepage</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/myFavorites?username=${username}">${username}'s Favorites</a>
		<a href="/myToWatch?username=${username}">${username}'s Watch List</a>
		<a href="/logout">Logout</a>
	</div>
	<h1>${username}'s Homepage</h1>
	<h2>${message}</h2>
	
	<div class=forms>
		<form action="/mySearch?username=${username}" method="POST">
			Search Movies: 
			<input type="text" value="" name="search"/>
			<input type="submit" value="Search"/>
		</form>
	</div>
	
</body>
</html>