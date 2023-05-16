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
<title>Detalle Canción</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col d-flex justify-content-end">
				<a href="/songs" class="btn btn-primary">Regresar a la lista</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3>Titulo canción:</h3>
			</div>
			<div class="col">
				<h3>${song.titulo}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3>Artista:</h3>
			</div>
			<div class="col">
				<h3>${song.artista}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3>clasificación</h3>
			</div>
			<div class="col">
				<h3>${song.clasificacion}</h3>
			</div>
		</div>
		<div class="row">
		<div class="col">
		<a href="/song/delete/${song.id}">Eliminar</a>
		</div>
		</div>
	</div>
</body>
</html>