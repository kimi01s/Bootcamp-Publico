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
<title>add title here</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-8">
				<form:form action="/language/new" method="POST"
					modelAttribute="newLang">
						<form:errors class="text-danger" path="name"/>
						<form:errors class="text-danger" path="creator"/>
						<form:errors class="text-danger" path="currentVersion" />
					<div class="mb-3">
						<form:label path="name" for="name" class="form-label">Nombre</form:label>
						<form:input path="name" type="text" class="form-control"
							id="name" name="name" />
						
						<form:label path="creator" for="creator" class="form-label">Creador</form:label>
						<form:input path="creator" type="text" class="form-control"
							id="creator" name="creator" />
						
						<form:label path="currentVersion" for="currentVersion" class="form-label">Version</form:label>
						<form:input path="currentVersion" type="text" class="form-control"
							id="currentVersion" name="currentVersion" />
					</div>
					<div class="row mb-3">
						<div class="col text-center">
							<button type="submit" class="btn btn-lg btn-primary">Guardar</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>