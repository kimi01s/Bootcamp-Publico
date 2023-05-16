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
<title>Top 10 canciones</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<ul>
					<c:forEach items="${songs}" var="song">
						<li>
							<h2>
								<c:out value="${song.clasificacion}" />
								- <a href="/songs/${song.id}"><c:out value="${song.titulo}" /></a>
								-
								<c:out value="${song.artista}" />
							</h2>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row">
		<div class="col">
		<a href="/songs">Volver a la lista</a>
		</div>
		</div>
	</div>
</body>
</html>