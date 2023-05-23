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
<title>nuevo producto</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<form:form action="/products/new" method="post"
					modelAttribute="newProduct">
					<div class="row mb-3">
						<form:errors class="text-danger" path="name"></form:errors>
						<form:errors class="text-danger" path="description"></form:errors>
						<form:errors class="text-danger" path="price"></form:errors>
					</div>
					<div class="form-outline mb-4">
						<form:label path="name" class="form-label" for="name">Nombre Producto</form:label>
						<form:input path="name" type="text" id="name" class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="description" class="form-label" for="description">Descripción</form:label>
						<form:input path="description" type="text" id="description" class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="price" class="form-label" for="price">Precio</form:label>
						<form:input path="price" type="text" id="price" class="form-control" />
					</div>
					<button type="submit" class="btn btn-outline-success btn-block mb-4">Crear producto</button>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a class="link-success" href="/index">volver atrás</a>
			</div>
		</div>
	</div>
</body>
</html>