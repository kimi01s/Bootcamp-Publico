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
<title>Todas las categorias</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row my-2">
			<div class="col">
				<a href="/categories/new" type="button"
					class="btn btn-outline-success">nueva categoria</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nombre categor�a</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allCat}" var="category">
							<tr>
								<td><a class="link-success"
									href="/categories/${category.id}">${category.name}</a></td>
								<td><a class="link-success"
									href="/categories/delete/${category.id}">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a class="link-success" href="/index">volver atr�s</a>
			</div>
		</div>
	</div>
</body>
</html>