<%@page import="com.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.UserLoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="components/common_css_js.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.container {
	padding: 2rem 0rem;
}

h4 {
	margin: 2rem 0rem 1rem;
}

.table-image {td , th { vertical-align:middle;
	
}
}
</style>

</head>
<body>
	<!-- Navbar start -->
	<%@include file="components/navbar.jsp"%>
	<!-- Navbar end -->

	<h6>
		<%@include file="components/message.jsp"%>
	</h6>

	<%
	List<UserBean> list = new ArrayList<UserBean>();
	list = (List) session.getAttribute("listOfUsers");
	%>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">S. No.</th>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">City</th>
							<th scope="col">State</th>
							<th scope="col">Country</th>
							<th scope="col">Zip</th>
							<th scope="col">Phone</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>

					<tbody>
						<%
						int count = 0;
						for (UserBean ub1 : list) {
						%>
						<form action="EditServlet" method="POST">
						<tr>
							<th scope="row"><%=++count%></th>
							<td><%=ub1.getFirstName() + " " + ub1.getLastName()%></td>
							<td><%=ub1.getAddress()%></td>
							<td><%=ub1.getCity()%></td>
							<td><%=ub1.getState()%></td>
							<td><%=ub1.getCountry()%></td>
							<td><%=ub1.getState()%></td>
							<td><%=ub1.getPhone()%></td>

							<td>
								<input type="hidden" value="<%=ub1.getPartyId()%>" name="partyId" />
								<button type="submit" class="btn btn-success">
									<i class="far fa-edit"></i>
								</button>


								<button type="button" class="btn btn-danger" onclick="deleteFunction(<%=ub1.getPartyId()%>)">
									<i class="far fa-trash-alt"></i>
								</button>
							</td>
						</tr>
						</form>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script>
	function deleteFunction(partyId)
	{
		console.log(partyId);
		 $.ajax({
			 url: "DeleteServlet",
		    data: {"partyId":partyId},
		    success:function(data)
		    {
		    	location.reload();
		    },
            error:function(){alert('error');}
		    });	
	}
</script>


</body>
</html>