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
<title>Mostrar Libro</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h2>
					<c:out value="${libro.title}" />
				</h2>
			</div>
			<div class="col-12">
			<p>descripción: <c:out value="${libro.description}"/></p>
				
			</div>
			<div class="col-12">
				<p>idioma: <c:out value="${libro.language}" /></p>
			</div>
			<div class="col-12">
				<p>paginas: <c:out value="${libro.numberOfPages}" /></p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/books">volver</a>
			</div>
			<div class="col">
				<a href="/books/edit/${libro.id}">Editar Libro</a>
			</div>
		</div>
	</div>
</body>
</html>