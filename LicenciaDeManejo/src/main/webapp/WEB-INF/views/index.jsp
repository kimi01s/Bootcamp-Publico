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
<title>Inicio</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<a class="btn btn-success" href="/person/new">agregar persona</a> 
			</div>
			<div class="col">
				<a class="btn btn-success" href="/licence/new">agregar
					licencia</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>License</th>
							<th>state</th>
							<th>Expiration Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${persons}" var="persona">
							<tr>
								<td><a href="/person/${persona.id}">${persona.firstName} ${persona.lastName}</a></td>
								<td>${persona.license.number}</td>
								<td>${persona.license.state}</td>
								<td>${persona.license.expirationDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>