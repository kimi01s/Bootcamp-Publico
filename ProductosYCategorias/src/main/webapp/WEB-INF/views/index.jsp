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
		<div class="row mt-4">
			<div class="col">
				<a href="/products/new" type="button"
					class="btn btn-outline-success">nuevo producto</a>
			</div>
			<div class="col">
				<a href="/categories/new" type="button"
					class="btn btn-outline-success">nueva categoria</a>
			</div>
			<div class="col">
				<a href="/allCategories" type="button"
					class="btn btn-outline-success">ver categorias</a>
			</div>
		</div>
		<div class="row mt-4">
			<div class="col">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>Nombre producto</th>
							<th>descripción</th>
							<th>precio</th>
							<th>action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="producto">
							<tr>
								<td><a class="link-success" href="/products/${producto.id}"><c:out
											value="${producto.name}"></c:out></a></td>
								<td>${producto.description}</td>
								<td>$ ${producto.price}</td>
								<td><a class="link-success" href="/products/delete/${producto.id}">eliminar</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>