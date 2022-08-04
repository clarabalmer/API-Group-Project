<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${username}'s Search Results</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/userhome?username=${username}">${username}'s Homepage</a>
		<a href="/myFavorites?username=${username}">${username}'s Favorites</a>
		<a href="/myToWatch?username=${username}">${username}'s Watch List</a>
		<a href="/logout">Logout</a>
	</div>
	<h1>${username}'s Search Results</h1>
	<h2>${message}</h2>
	<ul>
		<c:forEach var="movie" items="${movieArray}">
			<li>
				<div class="movieTitle">${movie.title} </div>
				<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
				<form action="/addMyFavorites" method="Post">
					<input type="hidden" name="username" value="${username}"/>
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<input type="submit" value="Add to Favorites"/>
				</form>

				<form action="/addToWatch" method="POST">
					<input type="hidden" name="username" value="${username}"/>
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<input type="submit" value="Add to Watchlist"/>
				</form>
				
				<br>
			</li>
		</c:forEach>
	</ul>
</body>
</html>