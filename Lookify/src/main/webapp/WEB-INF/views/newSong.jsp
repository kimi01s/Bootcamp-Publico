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
<title>Nueva Canción</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-6">
			<h2>Registra una nueva Cancion</h2>
				<form:form action="/song/new" method="post"
					modelAttribute="newSong">
					<div class="row mb-3">
						<form:errors class="text-danger" path="titulo"></form:errors>
						<form:errors class="text-danger" path="artista"></form:errors>
						<form:errors class="text-danger" path="clasificacion"></form:errors>
					</div>
					<div class="form-outline mb-4">
						<form:label path="titulo" class="form-label" for="titulo">Titulo</form:label>
						<form:input path="titulo" type="text" id="titulo"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="artista" class="form-label" for="artista">Artista</form:label>
						<form:input path="artista" type="text" id="artista"
							class="form-control" />
					</div>
					<div class="form-outline mb-4">
						<form:label path="clasificacion" class="form-label"
							for="clasificacion">Rating</form:label>
						<form:input path="clasificacion" type="number" id="clasificacion"
							class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
				</form:form>
				<a href="/songs">lista de canciones</a> 
			</div>
		</div>
	</div>
</body>
</html>