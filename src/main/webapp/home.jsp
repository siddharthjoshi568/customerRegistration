<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.UserLoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<!-- Navbar start -->
	<%@include file="components/navbar.jsp"%>
	<!-- Navbar end -->

	<h1>This is Home Page.</h1>

	<h2>
		<%@include file="components/message.jsp"%>
	</h2>

</body>
</html>