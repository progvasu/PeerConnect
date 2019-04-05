<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript">
var chatid = null;
var stompClient = null;
var sendurl = "/app";
var fetchurl = "/topic";

// did this
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
    //a = document.getElementById("chatid")
    //a.value=""
}

function showMessage(e) {
	alert("SHOW MESSAGE");
	document.getElementById("userinfo").append("<tr><td><span class='name-info'>" + e.senderid + "</span> " + e.message + " <span class='time-info'>" + e.date + "</span></td ></tr > ")
	alert("SHOW MESSAGE 2");
}


function validateMyForm()
{
	sendMessage();
	  return false;
}

	
	window.onload = function() {
		connect();
	}

</script>
</head>
<body>
	<div>
    	CHAT_ID: <input id="chatid" type="text" placeholder="fixed" value="${chatid}" name="chatid">
    </div>
    
    <div class="form-group">
        REQUEST ID: <input type="text" class="name" placeholder="username.." value="6" name="username" id="username">
    </div>
    
    <!-- to show messages -->
              <div class="row">
                  <div class="col-md-12">
                      <table id="conversation" class="table table-striped">
                          <tbody id="userinfo"></tbody>
                      </table>
                  </div>
              </div>
                
    <!-- input field to send messages -->
                <div class="row">
                    <form class="message-form form-inline" id="form" onsubmit="return validateMyForm();">
                        <div class="row">
                            <div class="col-md-11">
                                <div class="form-group">
                                    <input type="text" id="message" class="form-control" placeholder="type message here..">
                                </div>
                            </div>
                            <div class="col-md-1">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            	 <button id="send" class="btn btn-default" type="submit">Send</button>
                            </div>
                        </div>
                    </form>
                </div>   
</body>
</html>