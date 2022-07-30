<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Search</title>
</head>
<body>
	<h1>Movie App</h1>
	<form action="/search" method="POST">
		Search: <input type="text" name="search"/><br>
		<input type="submit"/>
	</form>
	<a href="/favorites">View Favorites</a>
</body>
</html>