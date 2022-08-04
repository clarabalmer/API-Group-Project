<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Overview</title>
</head>
<body>
	<h1>Overview</h1>
	<a href="/">Go To Home Page</a>
		<h3>${movie.title}</h3>
		<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/>
		<p>${movie.releaseDate}</p>
		<p>${movie.language}</p>
		<p>${movie.overview}</p>
	
		
		
		
		
		
	
</body>
</html>