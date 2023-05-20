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
<title>Contacto</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<form:form action="/contact/new" method="post"
					modelAttribute="newContact">
					<div class="row mb-3">
						<form:errors class="text-danger" path="address"></form:errors>
						<form:errors class="text-danger" path="city"></form:errors>
						<form:errors class="text-danger" path="state"></form:errors>
						<form:errors class="text-danger" path="student"></form:errors>
					</div>
					<div class="form-outline mb-4">
						<form:label path="student" class="form-label" for="student">Estudiantes</form:label>
						<form:select path="student" class="form-control">
							<c:forEach items="${studentsNoContact}" var="student">
								<form:option value="${student.id}">${student.firstName} ${student.lastName}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="form-outline mb-4">
						<form:label path="address" class="form-label" for="address">dirección</form:label>
						<form:input path="address" type="text" id="address"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="city" class="form-label" for="city">ciudad</form:label>
						<form:input path="city" type="text" id="city" class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="state" class="form-label" for="state">estado</form:label>
						<form:input path="state" type="text" id="state"
							class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">agregar información</button>
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