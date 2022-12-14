<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Overview</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/favorites">Public Favorites</a>
		<a href="/">Go To Home Page</a>	
	</div>
	
	<h1>${movie.title} Details</h1>
	<div class=details>
		<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/><br>
		<p>Released ${movie.releaseDate}</p>
		<p>${movie.overview}</p>
	</div>
</body>
</html>