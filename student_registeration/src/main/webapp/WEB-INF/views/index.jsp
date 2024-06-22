<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/test.css" />'>
</head>
<body class="login-page-body">

	<div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <p>Please check your data again.</p>
          </div>
        </div>
        <form:form action="/student_registeration/user" method="post" modelAttribute="user">
          <form:input path="name" type="text" placeholder="User Name"></form:input>
          <form:input path="password" type="password" placeholder="Password" ></form:input>
          <button>login</button>
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form:form>
      </div>
    </div>
</body>
</html>