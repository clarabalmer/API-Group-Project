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
	<ul>
		<c:forEach var="movie" items="${movieArray}">
			<li>
				${movie.title} <br>
				<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
				<form action="/confirm" method="Post">
					<input type="hidden" name="movieId" value="${movie.id}"/>
					<input type="submit" value="favorite this film"/>
				</form>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>