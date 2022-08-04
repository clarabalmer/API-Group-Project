<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Add</title>
</head>
<body>
	<h1>Movie Added To Favorites</h1>
	<a href="/favorites">View Favorites</a>
	<a href="/">Go To Home Page</a>
	<ul>
		<li>
			${movie.title} <br>
			${rating} Stars!<br>
			<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/>
		</li>
	</ul>
	<div>${message}</div>
</body>
</html>