<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
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
	<% String userId=request.getParameter("user_id");
		String userName=request.getParameter("user_name");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="navigation.jsp"></jsp:include>
		<div class="main_contents">
			<div id="sub_content">
				<form:form action="adduser" method="post" modelAttribute="user">
					<h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Registration</h2>
					<div class="row mb-4">
					<div class="col-auto">
						<label  for="user_id" class="visually-hidden">User Id</label>
						<input class="form-control" type="hidden" name="user_id" id="user_id" value="<%= userId  %>">
					</div>
					</div>
					<div class="row mb-4">
					<div class="col-auto">
						<label for="user_name"  class="visually-hidden">User Name</label>
						<input class="form-control" type="hidden" name="user_name" id="user_name"  value="<%= userName %>"></input>
					</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="email" class="col-md-2 col-form-label">Email</form:label>
						<div class="col-md-4">
							<form:input path="email" type="email" class="form-control"></form:input>
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="password" class="col-md-2 col-form-label">Password</form:label>
						<div class="col-md-4">
							<form:input type="password" class="form-control" path="password"></form:input>
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="confirmPassword" class="col-md-2 col-form-label">Confirm Password</form:label>
						<div class="col-md-4">
							<form:input type="password" class="form-control"
								path="confirmPassword"></form:input>
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="userRole" class="col-md-2 col-form-label">User Role</form:label>
						<div class="col-md-4">
							<form:select path="userRole">
								<form:option value="Admin">Admin</form:option>
								<form:option value="User">User</form:option>
							</form:select>
						</div>
					</div>
					<div class="row mb-4">
						<div class="col-md-4"></div>
						<div class="col-md-6">
							<button type="submit" class="btn btn-secondary col-md-2"
								data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
							<div class="modal fade" id="exampleModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Student
												Registration</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">

											<h5 style="color: rgb(127, 209, 131);">Registered
												Succesfully !</h5>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-success col-md-2"
												data-bs-dismiss="modal">Ok</button>

										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div id="testfooter">
		<span>Copyright &#169; ACE Inspiration 2022</span>
	</div>
	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}
	</script>
</body>
</html>