<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>

<body>
<table border="1">
<form:form modelAttribute="user" action="addUser">

<tr><td>Name : <form:input path="name" required="true"/> 
<form:errors path="name" cssStyle="color:red"></form:errors></td></tr>
<tr><td>Email : <form:input path="email" required="true"/>
<form:errors path="email" cssStyle="color:red"></form:errors></td></tr>
<tr><td><input type="submit" value="Sumit"></td></tr>
</form:form>
</table>
</body>
</html>