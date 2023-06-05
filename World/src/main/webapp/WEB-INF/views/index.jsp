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
<title>world DATABASE</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>world database</h1>
			</div>
		</div>
		<div class="row">
			<div class="col">
			<a href="/consulta/1">Consulta 1</a>
			<a href="/consulta/2">Consulta 2</a>
			<a href="/consulta/3">Consulta 3</a>
			<a href="/consulta/4">Consulta 4</a>
			<a href="/consulta/5">Consulta 5</a>
			<a href="/consulta/6">Consulta 6</a>
			<a href="/consulta/7">Consulta 7</a>
			<a href="/consulta/8">Consulta 8</a>			
			</div>
		</div>
	</div>
</body>
</html>