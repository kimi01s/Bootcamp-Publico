<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Register!</h1>
				<div class="row mb-3">
					<form:errors class="text-danger" path="user.*" />
				</div>
				<form:form method="POST" action="/registration"
					modelAttribute="user">
					<div class="form-outline mb-4">
						<form:label path="userName">userName:</form:label>
						<form:input class="form-control" type="text" path="userName" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="email">Email:</form:label>
						<form:input class="form-control" type="email" path="email" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="password">Password:</form:label>
						<form:password class="form-control" path="password" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="passwordConfirmation">Password Confirmation:</form:label>
						<form:password class="form-control" path="passwordConfirmation" />
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">Registrar</button>
				</form:form>

			</div>
			<div class="col">
				<h1>Login</h1>
				<p>
					<form:errors path="login.*" />
				</p>
				<form method="post" action="/login">
					<p>
						<label for="email">Email</label> <input type="text" id="email"
							name="email" />
					</p>
					<p>
						<label for="password">Password</label> <input type="password"
							id="password" name="password" />
					</p>
					<input type="submit" value="Login!" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>