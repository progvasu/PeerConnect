<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Group</title>
</head>
<body>
	${message}
	<h1>CREATE GROUP</h1>
	<form name="group" method="POST" action="/groups/create">
		Group Name: <input type="text" name="name"><br>
		Description: <input type="text" name="description"><br>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="CREATE">
	</form>
</body>
</html>