<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Request Accepted</h1>
		<c:if test="${not empty requestaccepted}">
							<c:forEach items="${requestaccepted}" var="request">				    
							    ${request.key.getRequestid()}<br>
							    ${request.key.getRequestmsg()}<br>
							    ${request.key.getCreatedate()}<br>
							    ${request.key.getCreatetime()}<br>
								<c:forEach items="${request.value}" var="acceptername">
										 <pre>${acceptername}</pre>
								</c:forEach>
								<br>--------------------------------------------------------<br>
							</c:forEach>
		</c:if>
		
	  
	

</body>
</html>