<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Faves</title>
</head>
<body>
	<h1>Favorites</h1>
	<a href="/">Go To Home Page</a>
	<ul>
		<c:forEach var="movie" items="${favMovieList}">
			<li>
				${movie.title} <br>
				<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
			
				<form action="/confirmDelete" method="Post">
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<input type="submit" value="Delete this film"/>
				</form>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>