<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Faves</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/">Go To Home Page</a>
	</div>
	<h1>Public Favorites</h1>
	<ul>
		<c:forEach var="movie" items="${favMovieList}" varStatus="status">
			<li>
				${movie.title} <br>
				${favList[status.index].rating}<br>
				<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
				<form action="overview" method="post">
					<input type="hidden" name="id" value="${movie.id}"/>
					<input type="submit" value="See Overview"/>
				</form>
				<form action="/confirm?action=delete" method="Post">
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<input type="hidden" name="rating" value="0"/>
					<input type="submit" value="Delete this film"/>
				</form>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>