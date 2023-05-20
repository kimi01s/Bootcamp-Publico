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
<title>Crear estudiante</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Crear estudiante</h1>
			<div class="col">
				<form:form action="/students/new" method="post"
					modelAttribute="newStudent">
					<div class="row mb-3">
						<form:errors class="text-danger" path="firstName"></form:errors>
						<form:errors class="text-danger" path="lastName"></form:errors>
						<form:errors class="text-danger" path="age"></form:errors>
					</div>
					<div class="form-outline mb-4">
						<form:label path="firstName" class="form-label" for="firstName">Nombre</form:label>
						<form:input path="firstName" type="text" id="firstName"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="lastName" class="form-label" for="lastName">apellido</form:label>
						<form:input path="lastName" type="text" id="lastName"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="age" class="form-label" for="age">edad</form:label>
						<form:input path="age" type="number" id="age" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">crear
						estudiante</button>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/">volver</a>
			</div>
		</div>
	</div>
</body>
</html>