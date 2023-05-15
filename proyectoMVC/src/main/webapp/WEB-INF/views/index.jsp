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
<title>Book API</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
		<div class="col-10"><h1>Libros</h1></div>
		<div class="col">
		<a href="books/new" class="btn btn-success">agregar libro</a>
		</div>
		</div>
		
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>TITLE</th>
							<th>DESCRIPTION</th>
							<th>LANGUAGE</th>
							<th>PAGES</th>
							<th>VER</th>
							<th>DELETE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${books}" var="book">
							<tr>
								<td><c:out value="${book.title}" /></td>
								<td><c:out value="${book.description}" /></td>
								<td><c:out value="${book.language}" /></td>
								<td><c:out value="${book.numberOfPages}" /></td>
								<td><a href="/books/${book.id}">ver</a></td>
								<td><a href="/books/delete/${book.id}">eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>