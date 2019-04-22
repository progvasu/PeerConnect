<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PC Login</title>
		<meta charset="utf-8">
		 <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
		<style>
			:root {
			  --input-padding-x: 1.5rem;
			  --input-padding-y: 0.75rem;
			}
			
			.login,
			.image {
			  min-height: 100vh;
			}
			
			.bg-image {
			  background-image: url('https://raw.githubusercontent.com/progvasu/CDNPeerConnect/master/login_poster3.png');
			  background-size: contain;
			   background-repeat: no-repeat;
			  background-position: left;
			}
			
			.login-heading {
			  font-weight: 300;
			}
			
			.btn-login {
			  font-size: 0.9rem;
			  letter-spacing: 0.05rem;
			  padding: 0.75rem 1rem;
			  border-radius: 2rem;
			}
			
			.form-label-group {
			  position: relative;
			  margin-bottom: 1rem;
			}
			
			.form-label-group>input,
			.form-label-group>label {
			  padding: var(--input-padding-y) var(--input-padding-x);
			  height: auto;
			  border-radius: 2rem;
			}
			
			.form-label-group>label {
			  position: absolute;
			  top: 0;
			  left: 0;
			  display: block;
			  width: 100%;
			  margin-bottom: 0;
			  /* Override default `<label>` margin */
			  line-height: 1.5;
			  color: #495057;
			  cursor: text;
			  /* Match the input under the label */
			  border: 1px solid transparent;
			  border-radius: .25rem;
			  transition: all .1s ease-in-out;
			}
			
			.form-label-group input::-webkit-input-placeholder {
			  color: transparent;
			}
			
			.form-label-group input:-ms-input-placeholder {
			  color: transparent;
			}
			
			.form-label-group input::-ms-input-placeholder {
			  color: transparent;
			}
			
			.form-label-group input::-moz-placeholder {
			  color: transparent;
			}
			
			.form-label-group input::placeholder {
			  color: transparent;
			}
			
			.form-label-group input:not(:placeholder-shown) {
			  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
			  padding-bottom: calc(var(--input-padding-y) / 3);
			}
			
			.form-label-group input:not(:placeholder-shown)~label {
			  padding-top: calc(var(--input-padding-y) / 3);
			  padding-bottom: calc(var(--input-padding-y) / 3);
			  font-size: 12px;
			  color: #777;
			}
		</style>
	</head>
	
	<body>
	<div class="container-fluid">
	  <div class="row no-gutter">
	    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
	    <div class="col-md-8 col-lg-6">
	      <div class="login d-flex align-items-center py-5">
	        <div class="container">
	          <div class="row">
	            <div class="col-md-9 col-lg-8 mx-auto">
	              <h3 class="login-heading mb-4">welcome</h3>
	              <form name="login" method="POST" action="/login">
	                <div class="form-label-group">
	                  <input type="text" id="inputEmail" class="form-control" name="username" placeholder="Email address" required autofocus>
	                  <label for="inputEmail">Email address</label>
	                </div>
	
	                <div class="form-label-group">
	                  <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
	                  <label for="inputPassword">Password</label>
	                </div>
	                
	                <div class="custom-control mb-3">
	                 	${error}${message}
	                </div>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign in</button>
	                <div class="text-center">
	                  <a class="small" href="/registration">New? Register Here!</a></div>
	              </form>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
	</body>
</html>
