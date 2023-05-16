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
<title>Find artist songs</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<p>Canciones de: ${artista}</p>
			</div>
			<div class="col-6">
				<form:form class="d-flex" action="/songs/search" method="GET"
					modelAttribute="findsong">
					<form:label path="artista" for="artist">Songs by artist:</form:label>
					<div class="form-group mx-sm-3 mb-2 col">
						<form:input path="artista" type="text" class="form-control"
							name="artist" id="artist" placeholder="Ej: Katy Perry" />
					</div>
					<form:button type="submit" class="btn btn-primary mb-2">New
						Search</form:button>
				</form:form>
			</div>
			<div class="col">
				<table class="table">
					<thead>
						<tr>
							<th>TITULO</th>
							<th>RATING</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${songs}" var="song">
							<tr>
								<td><a href="/song/view/${song.id}"><c:out
											value="${song.titulo}"></c:out></a></td>
								<td><c:out value="${song.clasificacion}"></c:out></td>
								<td><a href="/song/delete/${song.id}">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
			<a href="/songs">volver a lista completa</a>
			</div>
		</div>
	</div>
</body>
</html>