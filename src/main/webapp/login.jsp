<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>

	<!-- Navbar start -->
	<%@include file="components/navbar2.jsp"%>
	<!-- Navbar end -->

	<!-- Login form -->
	<div class="container">
		<br>
		<h1>Login here!</h1>
		<%@include file="components/message.jsp"%>
		<form action="Login" method="POST">
			<div class="row jumbotron">
				<div class="col-sm-12 form-group">
					<label for="userLoginId">User Login Id</label> <input type="text"
						name="userLoginId" class="form-control" id="userLoginId"
						aria-describedby="userLoginId" placeholder="Enter User Login Id"
						required>
				</div>
				<div class="col-sm-12 form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Password" required>
				</div>
				<div class="col-sm-12 form-group">
					<p>
						New User ? <a href="register.jsp">Create an account ?</a>
					</p>
				</div>
				<div class="col-sm-12 form-group mb-0">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
			</div>
		</form>
	</div>
	<!-- Login form ends -->

</body>
</html>