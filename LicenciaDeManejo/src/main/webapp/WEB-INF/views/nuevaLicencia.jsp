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
<title>Nueva licencia</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-6">
				<h2>Nueva licencia</h2>
				<form:form action="/licence/new" method="post"
					modelAttribute="newLicence">
					<div class="row mb-3">
						<form:errors class="text-danger" path="person"></form:errors>
						<form:errors class="text-danger" path="state"></form:errors>
						<form:errors class="text-danger" path="expirationDate"></form:errors>
					</div>
					<div class="form-outline mb-4">
						<form:label path="person" class="form-label" for="person">Persona</form:label>
						<form:select path="person" class="form-control">
							<form:option value="${selectDef}">Select</form:option>
							
							<c:forEach items="${personas}" var="persona">
								<form:option value="${persona.id}">${persona.firstName} ${persona.lastName}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="form-outline mb-4">
						<form:label path="state" class="form-label" for="state">Estado</form:label>
						<form:input path="state" type="text" id="state"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="expirationDate" class="form-label"
							for="expirationDate">Fecha expiración</form:label>
						<form:input path="expirationDate" type="date" id="expirationDate"
							class="form-control"/>
							
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">Crear</button>
				</form:form>
				<a href="/index">Inicio</a>
			</div>
		</div>
	</div>
</body>
</html>