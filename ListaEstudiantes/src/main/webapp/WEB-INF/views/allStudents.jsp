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
<title>All students</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>all students</h1>
				<table class="table">
					<thead>
						<tr>
							<th>Nombre completo</th>
							<th>Edad</th>
							<th>Dirección</th>
							<th>Ciudad</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaEstudiantes}" var="estudiante">
							<tr>
								<td><c:out value="${estudiante.firstName} ${estudiante.lastName}"/></td>
								<td><c:out value="${estudiante.age}" /></td>
								<td><c:out value="${estudiante.contact.address}" /></td>
								<td><c:out value="${estudiante.contact.city}" /></td>
								<td><c:out value="${estudiante.contact.state}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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