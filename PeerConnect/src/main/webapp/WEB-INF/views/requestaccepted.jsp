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
		    <c:forEach items="${requestaccepted}" var="lists">
		    <form name="chat" method="POST" action="/chat/chat">
		    ${lists.getChatid()}
    			<input type='hidden' id='chatid' name='chatid' value='${lists.getChatid()}'/>
    			 ${lists.getRequestid()}  ${lists.getAcceptby()}
    			<input type="submit" value="View Request">
    			 <br>
    			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		     
		    	
			</c:forEach>
		</c:if>
		
	  
	

</body>
</html>