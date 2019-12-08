<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/files/css/style.css">
</head>
<body> 


	<h4> Home Page : List of users in the project !</h4>
	<hr/>
	<p/>
	<a href="${pageContext.request.contextPath}/addUser">Add User</a>
	<table border="1">
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	</tr>
	
	<c:forEach var="run" items="${users}">
	<tr>
		<td>${run.userID}</td>
		<td>${run.name}</td>
		<td>${run.email}</td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>