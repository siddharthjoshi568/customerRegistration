<%@page import="com.bean.UserLoginBean"%>
<%
UserLoginBean ulb = (UserLoginBean) session.getAttribute("current-user");

//Checking if user is logged in or not
if (ulb == null) {
	session.setAttribute("message", "You are not logged in");
	response.sendRedirect("login.jsp");
	return;
}
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">MyProject</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			
		</ul>
		<%if(ulb==null){ %>

			<a class="btn btn-secondary m-2" href="login.jsp" style="color: #fff;">Login</a>
			
			<a class="btn btn-info m-2" href="register.jsp" style="color: #fff;">Register</a>
	
		<%}
		else{
		%>
		<a class="btn btn-info m-2" href="Logout" style="color: #fff;">Logout</a>
		<%} %>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>




