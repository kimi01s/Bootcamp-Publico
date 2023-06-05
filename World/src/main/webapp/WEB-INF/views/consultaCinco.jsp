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
<title>inserta un título aquí</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h3>consulta 5</h3>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>area superficie</th>
							<th>population</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${paisesMayorArea}" var="paisArea">
							<tr>
							</tr>
							<td><c:out value="${paisArea[0]}"></c:out></td>
							<td><c:out value="${paisArea[1]}"></c:out></td>
							<td><c:out value="${paisArea[2]}"></c:out></td>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>