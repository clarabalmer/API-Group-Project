<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Delete</title>
</head>
<body>
<h1>Movie Deleted From Favorites</h1>
<a href="/favorites">View Favorites</a>
<a href="/">Go To Home Page</a>
	<ul>
		<li>
			${movie.title} <br>
			<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/>
		</li>
	</ul>
</body>
</html>