<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
<link href="style.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class=links>
		<a href="/favorites">View Favorites</a>
		<a href="/">Go To Home Page</a>
	</div>
	<h1>${message}</h1>
	
	<ul>
		<li>
			${movie.title} <br>
			${rating} Stars!<br>
			<img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}"/>
		</li>
	</ul>
</body>
</html>