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
<title>Login page</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Login</h1>
				<div class="row mb-3">
					<form:errors class="text-danger" path="login.*" />
				</div>
				<form:form method="post" action="/login" modelAttribute="login">
					<div class="form-outline mb-4">
						<form:label path="email">Email: </form:label>
						<form:input class="form-control" path="email" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="password">contraseña: </form:label>
						<form:input type="password" class="form-control" path="password" />
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">Login</button>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/">todavia no tienes un usuario?</a>
			</div>
		</div>
	</div>
</body>
</html>