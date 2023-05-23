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
<title>Mostrar categoria</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h2>
					<c:out value="${categoria.name}"></c:out>
				</h2>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Productos</th>
							<th>Acción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${categoria.products}" var="producto">
							<tr>
								<td>${producto.name}</td>
								<td><a class="link-success" href="/productandcat/deleteProd/${producto.id}/${categoria.id}">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
			<h2>agregar producto</h2>
			<form:form action="/asociacion/${categoria.id}" method="post"
				modelAttribute="asoCat">
				<form:input type="hidden" path="category" value="${categoria.id}" />
				<form:select class="form-control" path="product">
					<c:forEach items="${productos}" var="producto">
						<form:option value="${producto.id} "> ${producto.name}  
									</form:option>
					</c:forEach>
				</form:select>
				<form:button class="btn btn-outline-success mt-4">Agregar</form:button>
			</form:form>
		</div>
		</div>
		
		<div class="row">
			<div class="col">
				<a class="link-success" href="/allCategories">volver atrás</a> |
				<a class="link-success" href="/category/edit/${categoria.id}">editar</a>
			</div>
		</div>
	</div>
</body>
</html>