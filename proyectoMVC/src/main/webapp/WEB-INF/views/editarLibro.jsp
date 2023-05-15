<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ page isErrorPage="true" %> 
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
<title>Editar Libro</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<form:form action="/books/edit/${libro.id}" method="post"
					modelAttribute="editBook">
					<input type="hidden" name="_method" value="put"/>
					<form:input path="id" type="hidden" value="${libro.id}" />
					<div class="mb-3">
						<form:label path="title" for="title" class="form-label">Titulo</form:label>
						<form:input path="title" type="text" class="form-control"
							id="title" name="title" value="${libro.title}" />
						<form:errors class="text-danger" path="title"/>
					</div>
					<div class="mb-3">
						<form:label path="description" for="description">Descripcion</form:label>
						<form:input path="description" class="form-control"
							id="description" rows="3" name="description"
							value="${libro.description}"></form:input>
						<form:errors class="text-danger" path="description" />
					</div>
					<div class="mb-3">
						<form:label path="language" for="language" class="form-label">Lenguaje</form:label>
						<form:input path="language" type="text" class="form-control"
							id="language" name="language" value="${libro.language}"></form:input>
						<form:errors class="text-danger" path="language" />
					</div>
					<div class="mb-3">
						<form:label path="numberOfPages" for="numberOfPages"
							class="form-label">Número de páginas</form:label>
						<form:input path="numberOfPages" type="number"
							class="form-control" id="numberOfPages" name="numPages"
							value="${libro.numberOfPages}" />
						<form:errors class="text-danger" path="numberOfPages" />
					</div>
					<div class="row mb-3">
						<div class="col text-center">
							<button type="submit" class="btn btn-lg btn-primary">registra
								tu libro</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
		<div class="col">
				<a href="/books">volver</a>
			</div>
		</div>
	</div>
</body>
</html>