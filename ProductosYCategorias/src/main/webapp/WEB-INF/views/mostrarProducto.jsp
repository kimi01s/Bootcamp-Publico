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
<title>Mostrar producto</title>

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
					<c:out value="${producto.name}"></c:out>
				</h2>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Categorias</th>
							<th>Acción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${producto.categories}" var="categoria">
							<tr>
								<td>${categoria.name}</td>
								<td><a class="link-success" href="/productandcat/delete/${categoria.id}/${producto.id}">Eliminar</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="col">
				<form:form action="/aso/${producto.id }" method="post"
					modelAttribute="asociacion">
					<div class="form-group">
						<form:input type="hidden" path="product" value="${producto.id }" />
						<form:label path="category" for="category">agregar categoria</form:label>
						<form:select class="form-control my-3" path="category"
							id="category">
							<c:forEach items="${categorias}" var="categoria">
								<form:option value="${categoria.id} "> ${categoria.name}  
									</form:option>
							</c:forEach>
						</form:select>
					</div>
					<form:button class="btn btn-outline-success">Agregar</form:button>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a class="link-success" href="/index">volver atrás</a> |
				<a class="link-success" href="/products/edit/${producto.id}">editar</a>
			</div>
		</div>
	</div>
</body>
</html>