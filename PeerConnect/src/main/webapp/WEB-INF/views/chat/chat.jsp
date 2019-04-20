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
  
  <!-- scripts for chat implementation -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  <script type="text/javascript">
	var chatid = null;
	var stompClient = null;
	var sendurl = "/app";
	var fetchurl = "/topic";

	function connect() {
    	var e = new SockJS('/websocket');
	    stompClient = Stomp.over(e);
	    chatid = document.getElementById("chatid").value
	    sendurl = "/app/" + chatid
	    fetchurl = "/topic/" + chatid
    
    	stompClient.connect({}, function (e) {
    		stompClient.subscribe(fetchurl + '/message', function (msg) {
            	var n = JSON.parse(msg.body);
            	showMessage(n)
       		})
    	});
	}

	function disconnect() {
    	null !== stompClient && stompClient.disconnect();
	}

	function sendMessage() {
		var name1 = "${_csrf.parameterName}";
		var value1 = "${_csrf.token}";
	
    	stompClient.send(sendurl + '/message2', {}, JSON.stringify({
			chatid:  document.getElementById("chatid").value,
        	message: document.getElementById("message").value,
        	name1: value1 
    	}));
	}

	function showMessage(e) {
		var div = document.getElementById('chatbox');

		if (${myid} == e.senderid)	{
			div.innerHTML += "<div class='row chatspacing'><div class='col-sm-4'></div><div class='col-sm-8'><div class='media border border-dark rounded-lg' style='padding: 5px;'><div class='media-body' style='word-break: break-all;'><h6 class='font-weight-bold' style='margin-bottom: 5px;'>&nbsp<small style='float: right; font-size: 12px'><i>" + e.date + "</i></small></h6><span style='font-size: 15px;'>" + e.message + "</span></div></div></div></div>";
		}
		else	{
			div.innerHTML += "<div class='row chatspacing'><div class='col-sm-8'><div class='media border border-dark rounded-lg' style='padding: 5px;'><div class='media-body' style='word-break: break-all;'><h6 class='font-weight-bold' style='margin-bottom: 5px;'>&nbsp;<small style='float: right; font-size: 12px'><i>" + e.date + "</i></small></h6><span style='font-size: 15px;'>" + e.message + "</span></div></div></div><div class='col-sm-4'></div></div>";
		}
		
		var myElement = document.getElementsByClassName("row chatspacing");
		var topPos = myElement[myElement.length-1].offsetTop;
		
		document.getElementById('chatbox').scrollTop = topPos;	

		document.getElementById('message').value = "";	
	}


	function validateMyForm()	{
		sendMessage();
	  	return false;
	}

	window.onload = function() {
		connect();
	}
  </script>
</head>
<body>
	<!-- hidden form fields -->
	<input id="chatid" type="hidden" value="${chatid}" name="chatid">
	
	<div class="container-fluid menutop">
		<div class="row bg-secondary" style="margin-right: 0px;">
			<div class="col-sm-12">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="margin-right: -15px">
					<a class="navbar-brand" href="#">
						<img src="https://raw.githubusercontent.com/progvasu/CDNPeerConnect/master/peer.png" width="35" height="35" class="d-inline-block align-top img-thumbnail" alt="">
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
  
	<div class="container-fluid" style="">
		<div class="row">
			<div class="col-sm-2 bg-light sidebarleft">
				<div class="nav flex-sm-column text-body">
					<a href="/home">
						<button type="button" class="btn btn-dark btn-block">HOME</button>
					</a>
					<button type="button" class="btn btn-dark btn-block">VIEW THIS REQUEST</button>
					<a href="/myrequests">
						<button type="button" class="btn btn-dark btn-block">MY REQUESTS</button>
					</a>
					<a href="/requestacceptedbyme/accepted">
						<button type="button" class="btn btn-dark btn-block">REQUESTS ACCEPTED BY ME</button>
					</a>
				</div>
			</div>

	    	<div class="col-sm-10 bg-secondary">
	      		<div class="row chathead">
	          		<span class="badge badge-dark chatheadlabel">Group Name</span> <span class="badgelabel" style="color: white">${groupname}</span>
	      		</div>
	      		<div class="row chathead">
	          		<span class="badge badge-dark chatheadlabel">Requestor Name</span> <span class="badgelabel" style="color: white">${requestorname}</span>
	      		</div>
	      		<div class="row chathead">
	          		<span class="badge badge-dark chatheadlabel">Acceptor Name</span> <span class="badgelabel" style="color: white">${acceptname}</span>
	      		</div>
	      		<div class="row chathead">
	          		<span class="badge badge-dark chatheadlabel">Request</span> <span class="badgelabel" style="color: white">${requestmsg}</span>
	      		</div>
	      		<div class="row bg-dark" style="height: 62.8vh; margin-top: 5px;">
					<div class="col-sm-2"></div>
					<div id="chatbox" class="col-sm-8 bg-light" style="height: 62.8vh; overflow-y: scroll; padding: 10px">
					    <c:if test="${not empty oldchatmsgs}">
					    	<c:forEach items="${oldchatmsgs}" var="list">
					    		<c:if test="${myid eq list.getSenderid()}">
					    			<div class="row chatspacing">
										<div class="col-sm-4"></div>
										<div class="col-sm-8">
											<div class="media border border-dark rounded-lg" style="padding: 5px;">
											    <div class="media-body" style="word-break: break-all;">
											    	<h6 class="font-weight-bold" style="margin-bottom: 5px;">&nbsp;<small style="float: right; font-size: 12px"><i>${list.getDate()}</i></small></h6>
											    	<span style="font-size: 15px;">${list.getMessage()}</span>
											    </div>
											</div>
										</div>
									</div>	
					    		</c:if>
					    		<c:if test="${myid ne list.getSenderid()}">
					    			<div class="row chatspacing">
								    	<div class="col-sm-8">
											<div class="media border border-dark rounded-lg" style="padding: 5px;">
											    <div class="media-body" style="word-break: break-all;">
											    	<h6 class="font-weight-bold" style="margin-bottom: 5px;">&nbsp;<small style="float: right; font-size: 12px"><i>${list.getDate()}</i></small></h6>
											    	<span style="font-size: 15px;">${list.getMessage()}</span>
											    </div>
											</div>
										</div>
										<div class="col-sm-4"></div>
									</div>
					    		</c:if>
					    	</c:forEach>
					    </c:if>
					</div>
					<div class="col-sm-2"></div>
				</div>  
				<div class="row bg-dark" style="height: 6.8vh; margin-top: 0px;">
					<div class="col-sm-2"></div>
					<div class="col-sm-8" style="padding: 4px;">
						<form id="form" onsubmit="return validateMyForm();">
							<div class="input-group" style="height:25px; padding: 0px">
								<input type="text" id="message" class="form-control" style="height:34px;" placeholder="Send Message" required>
								<div class="input-group-append">
								<button class="btn btn-info" style="height:34px;" type="submit">Send</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html> 