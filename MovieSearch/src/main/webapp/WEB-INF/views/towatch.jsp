<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${username}'s To Watch</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/userhome?username=${username}">${username}'s Homepage</a>
		<a href="/myFavorites?username=${username}">${username}'s Favorites</a>
		<a href="/logout">Logout</a>
	</div>
	<h1>${username}'s To Watch List</h1>
	<h2>${message}</h2>
	<ul>
		<c:forEach var="movie" items="${toWatch}" varStatus="status">
			<li>
				<div class="movieTitle">${movie.title} </div>
				<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
			
				<form action="/userDeleteToWatch" method="Post">
					<input type="hidden" name="username" value="${username}"/>
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<input type="submit" value="Delete from Watchlist"/>
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>