<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Chat</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://codepen.io/vasu-bansal/pen/ZZGEYV.css">
</head>
<body>
	<div class="container-fluid menutop">
		<div class="row bg-secondary" style="margin-right: 0px;">
			<div class="col-sm-12">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="margin-right: -15px">
					<a class="navbar-brand" href="#">
						<img src="peer.png" width="35" height="35" class="d-inline-block align-top img-thumbnail" alt="">
						Peer Connect
					</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<div class="dropdown">
							<button type="button" class="btn btn-info dropdown-toggle .btn-sm" data-toggle="dropdown">
							Settings
							</button>
							<div class="dropdown-menu dropdown-menu-right" >
								<a class="dropdown-item" href="#">My Profile</a>
								<a class="dropdown-item" href="#">Change Password</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Sign Out</a>
							</div>
						</div>
					</li>
				</ul>
				</nav>
			</div> 
		</div> 
	</div>
  
	<div class="container-fluid" style="">
		<div class="row">
			<div class="col-sm-2 bg-light sidebarleft">
				<div class="nav flex-sm-column text-body">
					<button type="button" class="btn btn-dark btn-block">HOME</button>
					<button type="button" class="btn btn-dark btn-block">VIEW THIS GROUP REQUESTS</button>
					<button type="button" class="btn btn-dark btn-block">MY REQUESTS</button>
					<button type="button" class="btn btn-dark btn-block">REQUESTS ACCEPTED BY ME</button>
				</div>
			</div>

	    	<div class="col-sm-10 bg-secondary" style="height: 90vh; overflow-y: scroll">
	      		<div class="row chathead">
	          		MY REQUESTS
	      		</div>
	      		<c:if test="${not empty myrequests}">
			      	<c:forEach items="${myrequests}" var="request">
			      		<div class="row bg-dark" style="margin-top: 5px">
							<div class="col-sm-2" style="padding: 10px;">
								<button type="button" class="btn btn-secondary btn-block" style="word-wrap: break-word; height: 100%">
									${request.getRequestmsg()}
								</button> 
							</div>
							<c:if test="${not empty request.getChatmaps()}">
								<div class="col-sm-10 bg-light" style="display: flex; flex-flow: row wrap;">
									<c:forEach items="${request.getChatmaps()}" var="chatmap">
										<div class="col-sm-6" style="padding: 10px;">
											${chatmap.getAcceptorname()}
											<span class="badge badge-secondary">${chatmap.getGroupname()}</span>
											<form name="chat" method="POST" action="/chat/chat">
									        	<input type='hidden' id='chatid' name='chatid' value='${chatmap.getChatid()}'/>
									        	<input type='hidden' id='valid' name='valid' value='true'/>
									        	<button type="submit" class="btn btn-outline-dark btn-sm">
													Open Chat
												</button>
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											</form>
										</div>							
									</c:forEach>
								</div>
							</c:if>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html> 