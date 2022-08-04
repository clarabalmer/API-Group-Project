<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
</head>
<body>
	<h1>Movie Results</h1>
	<a href="/favorites">View Favorites</a>
	<a href="/">Go To Home Page</a>
	<ul>
		<c:forEach var="movie" items="${movieArray}">
			<li>
				${movie.title} <br>
				<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
				<p>Add this film to the favorites list?<br>
				 Fill out a rating then hit submit!</p>
				<form action="/confirm" method="Post">
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<p>Personal Rating:</p>
					 <input type="number" name="rating" value="0" min="0" max="5"/><span>Stars</span><br>
					<input type="submit" value="Favorite this film"/><br>
				</form>
			<form action="/Overview" method="Post">
				<input type="hidden" name="id" value="${movie.id}"/>
					<input type="submit" value="${movie.title}"/><br>
				</form>
			
			</li>
		</c:forEach>
	</ul>
</body>
</html>