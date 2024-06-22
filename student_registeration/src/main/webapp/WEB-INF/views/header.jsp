<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/test.css" />'>
</head>
<body>
	<div id="testheader">
		<div class="container">
			<div class=row>
				<div class="col-md-5 ">
					<h3>
						<a href="/student_registeration/user">Student Registration</a>
					</h3>
				</div>
				<div class="col-md-6">
					<p>User: USR001 Harry</p>
					<p>
						Current Date :
						<% Date currentDate = new Date();SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");String formattedDate = dateFormat.format(currentDate);%>
						<%= formattedDate %>
					</p>
				</div>
				<div class="col-md-1">
					<input type="button" class="btn-basic" id="lgnout-button"
						value="Log Out" onclick="location.href='LGN001.html'">
				</div>
			</div>
		</div>
	</div>
</body>
</html>