<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Members</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://codepen.io/vasu-bansal/pen/ZZGEYV.css">
</head>
<body>
	<div class="container-fluid menutop" style="10vh">
		<div class="row bg-secondary" style="margin-right: 0px;">
			<div class="col-sm-12">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="margin-right: -15px">
					<a class="navbar-brand" href="#">
						<img src="https://raw.githubusercontent.com/progvasu/CDNPeerConnect/master/peer.png
" width="35" height="35" class="d-inline-block align-top img-thumbnail" alt="">
						Peer Connect
					</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<div class="dropdown">
							<button type="button" class="btn btn-info dropdown-toggle .btn-sm" data-toggle="dropdown">
							Settings
							</button>
							<div class="dropdown-menu dropdown-menu-right" >
								<!--<a class="dropdown-item" href="#">My Profile</a>
								<a class="dropdown-item" href="#">Change Password</a>
								<div class="dropdown-divider"></div>-->
								<form action="/logout" method="post">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            						<input class="dropdown-item" type="submit" value="Sign Out"/>
        						</form>
							</div>
						</div>
					</li>
				</ul>
				</nav>
			</div> 
		</div> 
	</div>
  
	<div class="container-fluid" style="height: 90vh">
		<div class="row" style="height: 100%">
			<div class="col-sm-2 bg-light sidebarleft">
				<div class="nav flex-sm-column text-body">
					<a href="/home">
						<button type="button" class="btn btn-dark btn-block">HOME</button>
					</a>
					<a href="/groups/create">
						<button type="button" class="btn btn-dark btn-block">CREATE GROUP</button>
					</a>
					<a href="/myrequests">
						<button type="button" class="btn btn-dark btn-block">MY REQUESTS</button>
					</a>
					<a href="/requestacceptedbyme/accepted">
						<button type="button" class="btn btn-dark btn-block">REQUESTS ACCEPTED BY ME</button>
					</a>
				</div>
			</div>

	    	<div class="col-sm-10 bg-secondary">
	    		<div class="row">
	    			<div class="col-sm-1"></div>
	    			<div class="col-sm-10 bg-light rounded" style="margin: 20px; padding: 10px;">
	    				<div class="row" style="margin: 0px; margin-bottom: 10px;">
	    					<div style="display: block; font-size: 30px; font-weight: bold;  text-align: center;">
	    						ADD MEMBERS
	    					</div>
	    					
	    				</div>
	    				<form name="members" method="POST" action="/groups/insertMembers">
	    				<div class="row bg-dark" style="margin: 0px; margin-bottom: 10px;">
	    					<div class="col-sm-12 bg-light" style="display: flex; flex-flow: row wrap;">
								<c:if test="${not empty candidate_members}">
									<c:forEach items="${candidate_members}" var="lists">
										<c:choose>
											<c:when test="${logged_id==lists.getUserid()}">
										    	<div class="col-sm-3 form-check" style="display: none; overflow: hidden; overflow-y: scroll; word-break: break-all;">
													<label class="form-check-label">
														<input type="checkbox" class="form-check-input" value="${lists.getUserid()}" checked name="member_ids">${lists.getUsername()}
												  	</label>
												</div>
										    </c:when> 
										    <c:otherwise>
												<div class="col-sm-3 form-check" style="overflow: hidden; overflow-y: scroll; word-break: break-all;">
													<label class="form-check-label">
														<input type="checkbox" class="form-check-input" value="${lists.getUserid()}" name="member_ids">${lists.getUsername()}
												  	</label>
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:if>
							</div>
	    				</div>
	    				<div class="row">
			    			<div class="col-sm-12" style="text-align: center">
			    				<input type="hidden" name="group_id" value="${group_id}"><br>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			    				<input type="submit" class="btn btn-dark" style="width: 25%; font-weight: bolder" name="submit" value="CREATE GROUP">
			    			</div>
			    		</div>
			    		</form>
	    			</div>
	    			<div class="col-sm-1"></div>
	    		</div>
			</div>
		</div>
	</div>
</body>
</html> 