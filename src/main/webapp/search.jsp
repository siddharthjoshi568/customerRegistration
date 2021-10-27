<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.UserLoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="components/common_css_js.jsp"%>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>
	<!-- Navbar start -->
	<%@include file="components/navbar.jsp"%>
	<!-- Navbar end -->

	<h1>Search here for your name....</h1>

	<h2>
		<%@include file="components/message.jsp"%>
	</h2>
	
	<!-- Search bar -->
		<div class="search-container my-4">
			<input onkeyup="search()" type="text" id="search-input" class="form-control" placeholder="Search here....." />
			<div class="search-result">
				<!-- Result appears here... -->
				<h2>This is search result.</h2>
			</div>
		</div>
	<!-- Search bar end -->


<script>
	const search = () =>{
		let query = $("#search-input").val();
		
		if(query=='')
		{
			$(".search-result").hide();	
		}
		else
		{
			//search here...
			console.log(query);
			$(".search-result").show();
			
			//sending request to servlet
			$.ajax({
				  type: "GET",
				  url: "SearchServlet",
				  data: {"query":query},
				  success: function(data){
				     $(".search-result").html(data);
				     console.log(data);
				  }
				});
		}
	};
</script>


</body>
</html>