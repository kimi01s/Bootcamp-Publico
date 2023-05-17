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
<title>Nueva persona</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-6">
				<h2>Nueva persona</h2>
				<form:form action="/person/new" method="post" modelAttribute="newPerson">
					<div class="row mb-3">
						<form:errors class="text-danger" path="firstName"></form:errors>
						<form:errors class="text-danger" path="lastName"></form:errors>
					</div>
					<div class="form-outline mb-4">
						<form:label path="firstName" class="form-label" for="firstName">Nombre</form:label>
						<form:input path="firstName" type="text" id="firstName"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="lastName" class="form-label" for="lastName">Apellido</form:label>
						<form:input path="lastName" type="text" id="lastName"
							class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">Crear</button>
				</form:form>
				<a href="/index">Inicio</a>
			</div>
		</div>
	</div>
</body>
</html>