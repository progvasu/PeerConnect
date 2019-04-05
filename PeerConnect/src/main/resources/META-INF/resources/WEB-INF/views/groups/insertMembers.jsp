<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add members to group</title>
</head>
<body>
	${message}
	<h1>ADD MEMBERS</h1>
	<form name="members" method="POST" action="/groups/insertMembers">
	Select Members: <br>
		<c:if test="${not empty candidate_members}">
		    <c:forEach items="${candidate_members}" var="lists">
		    	<c:choose>
				    <c:when test="${logged_id==lists.getUser_id()}">
				    	<input type="checkbox" value="${logged_id}" name="member_ids" checked="checked" style="visibility:hidden;">${lists.getUsername()}<br>
				    </c:when>    
				    <c:otherwise>
				        <input type="checkbox" value="${lists.getUser_id()}" name="member_ids">${lists.getUsername()}<br>
				    </c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
		<input type="hidden" name="group_id" value="${group_id}"><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="ADD">
	</form>
</body>
</html>