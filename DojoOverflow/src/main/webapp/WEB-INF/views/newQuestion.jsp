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
<title>new question</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row py-3">
			<div class="col">
				<h1>What is your question?</h1>
			</div>
			<div class="col text-end">
				<a href="/" class="btn btn-outline-success">atrás</a>
			</div>
		</div>
		<div class="row">
			<div class="col-6">
				<form method="post" action="/questions/new">
					<div class="form-group row mb-3">
						<label id="question" for="question"
							class="col-sm-3 col-form-label">Question:</label>
						<div class="col-sm-9">
							<textarea name="question" class="form-control" id="question"
								required></textarea>
						</div>
					</div>
					<div class="form-group row mb-3">
						<label id="tags" for="tags" class="col-sm-3 col-form-label">Tags:</label>
						<div class="col-sm-9">
							<input name="tags" class="form-control" id="tags"
								placeholder="ej: papa, verdura, rojo" pattern="^(\w+\s?\,\s?)$"
								required />
						</div>
					</div>
					<div class="form-group row mb-3">
						<div class="col text-end">
							<button class="btn btn-outline-success">submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>