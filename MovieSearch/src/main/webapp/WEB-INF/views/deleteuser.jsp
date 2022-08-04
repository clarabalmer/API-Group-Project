<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Account?</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class=links>
		<a href="/userhome?username=${username}">${username}'s Homepage</a>
		<a href="/myFavorites?username=${username}">${username}'s Favorites</a>
		<a href="/myToWatch?username=${username}">${username}'s Watch List</a>
		<a href="/logout">Logout</a>
	</div>
	<h1>Delete ${username}'s Account?</h1>
	<h4>Retype your username into the text box</h4>
	<div class=forms>
		<form action="/reallyDelete" method="Post">
			<input type="hidden" name="username" value="${username}"/>
			<input type="text" name="confirmUsername"/>
			<input type="submit" value="Delete Account"/>
		</form>
	</div>
	
	
</body>
</html>