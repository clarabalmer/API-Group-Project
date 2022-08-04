<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${movie.title} Details</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/userhome?username=${username}">${username}'s Homepage</a>
		<a href="/myFavorites?username=${username}">${username}'s Favorites</a>
		<a href="/myToWatch?username=${username}">${username}'s Watch List</a>
		<a href="/logout">Logout</a>
	</div>
	<h1>${movie.title} Details</h1>
	<div class=details>
		<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
		<p>Released ${movie.releaseDate}</p>
		<p>${movie.overview}</p>
	</div>
	
</body>
</html>