<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
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
	<jsp:include page="header.jsp"></jsp:include>
	<!-- <div id="testsidebar">Hello World </div> -->
	<div class="container">
		<jsp:include page="navigation.jsp"></jsp:include>
		<div class="main_contents">
			<div id="sub_content">
				<form:form class="row g-3 mt-3 ms-2" action="adduser" method="get"  modelAttribute="user">
					<div class="col-auto">
						<form:label path="user_id" class="visually-hidden">User Id</form:label>
						<form:input class="form-control" path="user_id" value="${user.user_id}"></form:input>
					</div>
					<div class="col-auto">
						<form:label path="user_name" class="visually-hidden">User
							Name</form:label> <form:input type="text" class="form-control" path="user_name"  value="${user.user_name }"></form:input>
					</div>
					<div class="col-auto">
						<button type="button" class="btn btn-primary mb-3">Search</button>
					</div>
					<div class="col-auto">
						<button type="submit" class="btn btn-secondary">Add</button>
					</div>
					<div class="col-auto">
						<button type="button" class="btn btn-danger mb-3">Reset</button>
					</div>
				</form:form>
				<table class="table table-striped" id="stduentTable">
					<thead>
						<tr>
							<th scope="col">User ID</th>
							<th scope="col">User Name</th>
							<th scope="col">Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td scope="row">${ user.user_id}</td>
								<td>${user.user_name}</td>
								<td>
								<a href="/student_registeration/edituser/${user.user_id}">
									<button type="button" class="btn btn-success  "
										>Update</button>
								</a>
								</td>
								<td>
									<a href="/student_registeration/deleteuser/${user.user_id}">
										<button type="submit" class="btn btn-secondary mb-3"
										data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Student
									Deletion</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<h5 style="color: rgb(127, 209, 131);">Are you sure want to
									delete !</h5>
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