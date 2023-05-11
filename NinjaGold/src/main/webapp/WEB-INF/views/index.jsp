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
<title>Ninja Gold Game</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<p>
					You Gold: <span
						class="border border-primary border-3 m-2 d-inline-block ps-4 pe-4">${gold}</span>
				</p>
			</div>
		</div>
		<div class="row mb-5">
			<div class="col text-center">
				<form action="/gold" method="POST">
					<h2 class="text-center">Farm</h2>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="keyCode" value="farm" />
					<button type="submit" class="btn btn-info " id="farm" name="farm">Find
						Gold!</button>
				</form>
			</div>
			<div class="col text-center">
				<form action="/gold" method="POST">
					<h2 class="text-center">Cave</h2>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="keyCode" value="cave" />
					<button type="submit" class="btn btn-info " id="cave" name="cave">Find
						Gold!</button>
				</form>
			</div>
			<div class="col text-center">
				<form action="/gold" method="POST">
					<h2 class="text-center">House</h2>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="keyCode" value="house" />
					<button type="submit" class="btn btn-info " id="house" name="house">Find
						Gold!</button>
				</form>
			</div>
			<div class="col text-center">
				<form action="/gold" method="POST">
					<h2 class="text-center">Casino</h2>
					<p>(earns/takes 0-50 gold)</p>
					<input type="hidden" name="keyCode" value="casino" />
					<button type="submit" class="btn btn-info " id="casino"
						name="casino">Find Gold!</button>
				</form>
			</div>

		</div>
		<div class="row">
			<div class="col">
				<form action="/gold" method="POST">
					<input type="hidden" name="keyCode" value="reset" />
					<button type="submit" class="btn btn-info " id="reset" name="reset">Reset</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<jsp:include page="actividades.jsp" />
			</div>
		</div>

	</div>
</body>
</html>