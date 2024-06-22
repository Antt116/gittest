<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/test.css" />'>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- <div id="testsidebar">Hello World </div> -->
	<div class="container">
		<jsp:include page="navigation.jsp"></jsp:include>
		<div class="main_contents">
			<div id="sub_content">
				<form:form action="/student_registeration/addstudent" method="post" modelAttribute="student">
					<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student
						Registration</h2>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="stu_id" class="col-md-2 col-form-label">Student
							ID</form:label>
						<div class="col-md-4">
							<form:input type="text" path="stu_id" class="form-control" ></form:input>
						</div>
						<form:errors path='stu_id' cssClass="text-danger"></form:errors>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="stu_name" class="col-md-2 col-form-label">Name</form:label>
						<div class="col-md-4">
							<form:input type="text" path="stu_name" class="form-control" ></form:input>
						</div>
						<form:errors path='stu_name' cssClass="text-danger"></form:errors>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="stu_dob" class="col-md-2 col-form-label">DOB</form:label>
						<div class="col-md-4">
							<form:input type="date" path="stu_dob" class="form-control" id="dob"></form:input>
						</div>
						<form:errors path="stu_dob" cssClass="text-danger"></form:errors>
					</div>
					<fieldset class="row mb-4">
						<div class="col-md-2"></div>
						<legend class="col-form-label col-md-2 pt-0">Gender</legend>
						<div class="col-md-4">
							<div class="form-check-inline">
								<form:radiobutton class="form-check-input" 
									path="stu_gender" value="M" label="Male"/>
							</div>
							<div class="form-check-inline">
								<form:radiobutton class="form-check-input" 
									path="stu_gender" value="F" label="Female"/>
							</div>
							<form:errors path="stu_gender" cssClass="text-danger"></form:errors>
						</div>
					</fieldset>

					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="stu_phone" class="col-md-2 col-form-label">Phone</form:label>
						<div class="col-md-4">
							<form:input type="text" path="stu_phone" class="form-control"></form:input>
						</div>
						<form:errors path="stu_phone" cssClass="text-danger"></form:errors>
					</div>
					<div class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="educations" class="col-md-2 col-form-label">Education</form:label>
						<div class="col-md-4">
							<form:select class="form-select" path="educations" aria-label="Education" required="true" id="education">
								<form:options items="${selected_edu}" itemValue="eid" itemLabel="ename"/>
							</form:select>
						</div>
					</div>
					
					<fieldset class="row mb-4">
						<div class="col-md-2"></div>
						<form:label path="courses" class="col-form-label col-md-2 pt-0">Attend</form:label>
						<div class="col-md-4">
							<div class="">
								<form:checkboxes items="${selected_course}" path="courses" itemValue="id" itemLabel="course_name"></form:checkboxes>
								<span> </span>
							</div>
						</div>
					</fieldset>
<!-- 					<div class="row mb-4"> -->
<!-- 						<div class="col-md-2"></div> -->
<!-- 						<label for="name" class="col-md-2 col-form-label">Photo</label> -->
<!-- 						<div class="col-md-4"> -->
<!-- 							<input type="file" class="form-control" id="name"> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="row mb-4">
						<div class="col-md-4"></div>

						<div class="col-md-4">
							<button type="button" class="btn btn-danger ">Reset</button>
							<button type="submit" class="btn btn-secondary col-md-2"
								data-bs-toggle="modal" data-bs-target="#exampleModal">
								Add</button>
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